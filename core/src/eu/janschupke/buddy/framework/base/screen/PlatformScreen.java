package eu.janschupke.buddy.framework.base.screen;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Base class for platform style screens (levels),
 * with gravity, left/right movement and jumps.
 */
public abstract class PlatformScreen extends GameScreen {
    public PlatformScreen(final App app) {
        super(app);
    }

    @Override
    public void show() {
        super.show();
        inputMultiplexer.addProcessor(app.getInputProcessor(Config.Input.PLATFORM));
    }

    @Override
    public void hide() {
        super.hide();
        removeInputProcessor(app.getInputProcessor(Config.Input.PLATFORM));
    }

    @Override
    public void pause() {
        super.pause();
        removeInputProcessor(app.getInputProcessor(Config.Input.PLATFORM));
    }

    @Override
    public void resume() {
        super.resume();
        inputMultiplexer.addProcessor(app.getInputProcessor(Config.Input.PLATFORM));
    }
}

