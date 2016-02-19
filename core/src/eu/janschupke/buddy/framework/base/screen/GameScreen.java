package eu.janschupke.buddy.framework.base.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Item;
import eu.janschupke.buddy.framework.base.entity.Obstacle;
import eu.janschupke.buddy.framework.base.entity.Unit;
import eu.janschupke.buddy.framework.base.entity.WorldEntity;
import eu.janschupke.buddy.framework.base.event.LevelEventHandler;
import eu.janschupke.buddy.framework.base.exception.NoHudException;
import eu.janschupke.buddy.framework.base.quest.QuestManager;
import eu.janschupke.buddy.framework.base.world.BaseWorld;
import eu.janschupke.buddy.framework.config.Config;
import eu.janschupke.buddy.framework.input.BaseInputProcessor;
import eu.janschupke.buddy.framework.util.Utility;

/**
 * Base class for all in-game screens (levels).
 * @author jan.schupke@gmail.com
 */
public abstract class GameScreen extends BaseScreen {
    protected BaseWorld world;
    protected boolean inMenu;
    protected Config.Huds screenHud;
    protected BaseInputProcessor levelInputProcessor;
    protected LevelEventHandler levelEventHandler;
    protected QuestManager questManager;
    protected LevelState levelState;

    private boolean paused = false;
    private String hintCache;

    public GameScreen(final App app) {
        super(app);
        Gdx.app.debug("GameScreen#<init>", "Constructing");
    }

    @Override
    public void show() {
        Gdx.app.debug("GameScreen#show", "Showing");
        super.show();
        paused = false;
        inMenu = false;
    }

    @Override
    public void hide() {
        Gdx.app.debug("GameScreen#hide", "Hiding");
        super.hide();
        paused = true;
    }

    @Override
    public void pause() {
        if (paused) {
            return;
        }

        Gdx.app.debug("GameScreen#pause", "Pausing");
        super.pause();
        try {
            // Some hint may already be set.
            hintCache = Utility.getHud(app).getHintTable().getHint();
            Utility.getHud(app).getHintTable().update(app.getLang().get("hint.global.paused"));
        } catch (NoHudException e) {
            Gdx.app.log("GameScreen#pause", "No HUD problem.");
        }
        paused = true;
    }

    @Override
    public void resume() {
        if (!paused) {
            return;
        }

        Gdx.app.debug("GameScreen#resume", "Resuming");
        super.resume();
        try {
            Utility.getHud(app).getHintTable().update(hintCache);
        } catch (NoHudException e) {
            Gdx.app.log("GameScreen#pause", "No HUD problem.");
        }
        if (!inMenu) paused = false;
    }

    /**
     * Renders ann unit sprites, including the player.
     */
    protected void renderUnits() {
        for (Unit u : world.getUnits()) {
            u.draw(app.getBatch());
        }

        world.getPlayerUnit().draw(app.getBatch());
    }

    /**
     * Explicitly updates the state of all units without rendering their sprites.
     * @param delta Elapsed time since last update.
     */
    protected void updateUnits(float delta) {
        for (Unit u : world.getUnits()) {
            u.update(delta);
        }

        world.getPlayerUnit().update(delta);
    }

    /**
     * Renders all non-unit and non-player sprites.
     */
    protected void renderObjects() {
        for (Item i : world.getItems()) {
            i.draw(app.getBatch());
        }

        for (WorldEntity o : world.getObstacles()) {
            if (o instanceof Obstacle) {
                ((Obstacle)o).draw(app.getBatch());
            }
        }
    }

    /**
     * Explicitly updates the state of all items without rendering their sprites.
     * @param delta Elapsed time since last update.
     */
    protected void updateObjects(float delta) {
        for (Item i : world.getItems()) {
            i.update(delta);
        }

        for (WorldEntity o : world.getObstacles()) {
            if (o instanceof Obstacle) {
                ((Obstacle)o).update(delta);
            }
        }
    }

    /**
     * Renders all currently occurring particle effects.
     * @param delta Delta time.
     */
    protected void renderParticleEffects(float delta) {
        for (int i = world.getPooledEffects().size - 1; i >= 0; i--) {
            ParticleEffectPool.PooledEffect effect = world.getPooledEffects().get(i);
            effect.draw(app.getBatch(), delta);

            if (effect.isComplete()) {
                effect.free();
                world.getPooledEffects().removeIndex(i);
            }
        }
    }

    /**
     * Pauses the game and swaps the current HUD with the menu UI.
     * Resumes the game if it already is in menu.
     */
    public void toggleMenu() {
        Gdx.app.debug("GameScreen#toggleMenu", "Toggling menu");
        app.getResourceHandler().playSound(app.getResourceHandler().getMenuButtonSound());
        if (inMenu) {
            inMenu = false;
            app.swapHuds(app.getHud(screenHud));
            resume();
        } else {
            inMenu = true;
            pause();
            app.getEventHandler().showGameMenu();
        }
    }

    /**
     * Toggles event log visibility.
     */
    public void toggleEventLog() {
        try {
            Utility.getHud(app).toggleEventLog();
            Utility.getHud(app).getIndicatorTable().deactivateEvent();
        } catch (NoHudException e) {
            Gdx.app.log("GameScreen#toggleEventLog", "No HUD problem.");
        }
    }

    /**
     * Toggles quest log visibility.
     */
    public void toggleQuestLog() {
        try {
            Utility.getHud(app).toggleQuestLog();
            Utility.getHud(app).getIndicatorTable().deactivateQuest();
        } catch (NoHudException e) {
            Gdx.app.log("GameScreen#toggleQuestLog", "No HUD problem.");
        }
    }

    /**
     * Toggles inventory visibility.
     */
    public void toggleInventory() {
        try {
            Utility.getHud(app).toggleInventory();
            Utility.getHud(app).getIndicatorTable().deactivateItem();
        } catch (NoHudException e) {
            Gdx.app.log("GameScreen#toggleInventory", "No HUD problem.");
        }
    }

    // For world step calculations.
    private float step = 1.0f / 60.0f;
    private double accumulator;

    /**
     * Performs the Box2D world step.
     * @param delta Elapsed time since last update.
     */
    @Override
    public void update(float delta) {
        if (!paused) {
            accumulator += delta;
            while (accumulator >= step) {
                world.getBoxWorld().step(step, 6, 2);
                accumulator -= step;
            }
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        renderContent(delta);
        app.getBatch().setProjectionMatrix(view.getSceneCamera().combined);
        renderStage();
        updateCamera();
    }

    /**
     * Renders level content, like world, units etc.,
     * according to the current debug mode.
     * @param delta Elapsed time since last render.
     */
    private void renderContent(float delta) {
        // Render the world.
        world.getRenderer().setView(view.getCamera());
        AnimatedTiledMapTile.updateAnimationBaseTime();
        app.getBatch().setProjectionMatrix(view.getCamera().combined);
        view.getViewport().apply();

        updateUnits(delta);
        updateObjects(delta);
        if (app.getSettingsManager().getConfig().getWorldDebugRendering() == Config.WorldDebugRendering.ALL ||
                app.getSettingsManager().getConfig().getWorldDebugRendering() == Config.WorldDebugRendering.GRAPHICS) {
            renderLevel(delta);
        }
        if (paused) {
            dimScreen();
        }
        if (app.getSettingsManager().getConfig().getWorldDebugRendering() == Config.WorldDebugRendering.ALL ||
                app.getSettingsManager().getConfig().getWorldDebugRendering() == Config.WorldDebugRendering.DEBUG) {
            world.getDebugRenderer().render(world.getBoxWorld(), view.getCamera().combined);
        }
    }

    /**
     * Renders all user-relevant parts of the screen - world, units, objects, effects.
     * @param delta Elapsed time since last render.
     */
    private void renderLevel(float delta) {
        world.getRenderer().render();
        app.getBatch().begin();
        renderUnits();
        renderObjects();
        renderParticleEffects(delta);
        app.getBatch().end();
    }

    /**
     * Draws partially transparent grey rectangle across the screen,
     * in order to make a dim effect.
     */
    private void dimScreen() {
        ShapeRenderer shapeRenderer = new ShapeRenderer();
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(new Color(0, 0, 0, 0.8f));
        shapeRenderer.rect(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        shapeRenderer.end();
        Gdx.gl.glDisable(GL20.GL_BLEND);
    }

    private void updateCamera() {
        view.updateCameraPosition(world.getPlayerUnit());

        // Limit the camera to the boundaries of the current map.
        view.limitCamera();
        view.getCamera().update();
        view.getSceneCamera().update();
    }

    @Override
    public void resize(int width, int height) {
        view.getViewport().update(width, height);
    }

    @Override
    public void dispose() {
        world.dispose();
    }

    public BaseWorld getWorld() {
        return world;
    }

    public LevelEventHandler getLevelEventHandler() {
        return levelEventHandler;
    }

    public QuestManager getQuestManager() {
        return questManager;
    }

    public boolean isPaused() {
        return paused;
    }

    public LevelState getLevelState() {
        return levelState;
    }
}
