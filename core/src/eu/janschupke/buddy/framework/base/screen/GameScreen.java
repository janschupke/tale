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
import eu.janschupke.buddy.framework.base.event.LevelEventHandler;
import eu.janschupke.buddy.framework.base.ui.dialog.BaseDialog;
import eu.janschupke.buddy.framework.base.world.BaseWorld;
import eu.janschupke.buddy.framework.config.Config;
import eu.janschupke.buddy.framework.input.BaseInputProcessor;

/**
 * Base class for all in-game screens (levels).
 */
public abstract class GameScreen extends BaseScreen {
    protected BaseWorld world;
    protected boolean inMenu;
    protected Config.Huds screenHud;
    protected BaseInputProcessor levelInputProcessor;
    protected LevelEventHandler levelEventHandler;

    private boolean paused = false;

    public GameScreen(final App app) {
        super(app);
        Gdx.app.debug("GameScreen#<init>", "Constructing");
    }

    @Override
    public void show() {
        Gdx.app.debug("GameScreen#show", "Showing");
        super.show();
        inputMultiplexer.addProcessor(levelInputProcessor);
        inputMultiplexer.addProcessor(app.getInputProcessor(Config.Input.GAME));
        paused = false;
        inMenu = false;
    }

    @Override
    public void hide() {
        Gdx.app.debug("GameScreen#hide", "Hiding");
        super.hide();
        removeInputProcessor(levelInputProcessor);
        removeInputProcessor(app.getInputProcessor(Config.Input.GAME));
        paused = true;
    }

    @Override
    public void pause() {
        Gdx.app.debug("GameScreen#pause", "Pausing");
        super.pause();
        removeInputProcessor(levelInputProcessor);
        paused = true;
    }

    @Override
    public void resume() {
        Gdx.app.debug("GameScreen#resume", "Resuming");
        super.resume();
        inputMultiplexer.addProcessor(levelInputProcessor);
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

        for (Obstacle o : world.getObstacles()) {
            o.draw(app.getBatch());
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

        for (Obstacle o : world.getObstacles()) {
            o.update(delta);
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
     * Shows/hides provided dialog instance.
     * @param dialog Dialog to be toggled.
     */
    private void toggleDialog(BaseDialog dialog) {
        if (dialog.isShown()) {
            dialog.hide();
            return;
        }
        dialog.show(app.getUi());
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

    private void renderLevel(float delta) {
        world.getRenderer().render();
        app.getBatch().begin();
        renderUnits();
        renderObjects();
        renderParticleEffects(delta);
        app.getBatch().end();
    }

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
}
