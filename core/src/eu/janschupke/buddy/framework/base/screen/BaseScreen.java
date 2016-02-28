package eu.janschupke.buddy.framework.base.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.View;
import eu.janschupke.buddy.framework.config.Config;
import eu.janschupke.buddy.framework.config.enumeration.InputProcessors;
import eu.janschupke.buddy.framework.input.BaseInputProcessor;

/**
 * Base class for all game states / screens.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class BaseScreen extends ScreenAdapter {
    protected final App app;
    protected View view;
    protected Music backgroundMusic;
    protected InputMultiplexer inputMultiplexer;

    public BaseScreen(final App app) {
        this.app = app;

        inputMultiplexer = new InputMultiplexer();
        Gdx.input.setInputProcessor(inputMultiplexer);

        inputMultiplexer.addProcessor(app.getUi());
        inputMultiplexer.addProcessor(app.getInputProcessor(InputProcessors.GLOBAL));
    }

    /**
     * Initiates view based on the world dimensions and screen resolution.
     *
     * @param width  World width, in world units.
     * @param height World height, in world units.
     */
    protected void initView(float width, float height) {
        int viewportWidth = Config.VIEWPORT_WIDE_WIDTH;
        int viewportHeight = Config.VIEWPORT_WIDE_HEIGHT;

        // Resolution is set to 4:3 if this is true. 4:3 resolutions are on the latter half of the resolution list.
        if (app.getSettingsManager().getConfig().getResolutionIndex() >= Config.NARROW_VIEW_THRESHOLD) {
            viewportWidth = Config.VIEWPORT_WIDTH;
            viewportHeight = Config.VIEWPORT_HEIGHT;
        }
        view = new View(viewportWidth, viewportHeight, width, height);
    }

    /**
     * Safely removes an input processor from the multiplexer.
     *
     * @param processor Processor to be removed.
     */
    public void removeInputProcessor(BaseInputProcessor processor) {
        Gdx.app.postRunnable(() -> {
            inputMultiplexer.removeProcessor(processor);
        });
    }

    @Override
    public void show() {
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        app.getEventHandler().triggerMusic(true);
    }

    @Override
    public void hide() {
        app.getEventHandler().triggerMusic(false);
    }

    /**
     * All per-iteration logic goes here.
     *
     * @param delta Elapsed time since last update.
     */
    public abstract void update(float delta);

    /**
     * All rendering and no logic goes here.
     *
     * @param delta Elapsed time since last update.
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void dispose() {
        if (backgroundMusic != null) {
            backgroundMusic.dispose();
        }
    }

    /**
     * Renders all Scene2D UI elements.
     */
    protected void renderStage() {
        app.getUi().getViewport().apply();
        app.getUi().act(Gdx.graphics.getDeltaTime());
        app.getUi().draw();
    }

    public Music getBackgroundMusic() {
        return backgroundMusic;
    }

    public App getApp() {
        return app;
    }

    public View getView() {
        return view;
    }
}
