package eu.janschupke.buddy.framework.base.screen;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Base class for top-down screens (levels).
 * Has no gravity. Units can move to all 4/8 directions, no jumping.
 */
public abstract class TopDownScreen extends GameScreen {
    public TopDownScreen(final App app) {
        super(app);
    }

    @Override
    public void show() {
        super.show();
        inputMultiplexer.addProcessor(app.getInputProcessor(Config.Input.TOPDOWN));
    }

    @Override
    public void hide() {
        super.hide();
        removeInputProcessor(app.getInputProcessor(Config.Input.TOPDOWN));
    }

    @Override
    public void pause() {
        super.pause();
        removeInputProcessor(app.getInputProcessor(Config.Input.TOPDOWN));
    }

    @Override
    public void resume() {
        super.resume();
        inputMultiplexer.addProcessor(app.getInputProcessor(Config.Input.TOPDOWN));
    }
}
