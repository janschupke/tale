package eu.janschupke.tale.base.input;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.screen.GameScreen;
import eu.janschupke.tale.content.config.Hotkeys;

/**
 * Input processor for platform-style game screens.
 * Handles 2D platformer movement with gravity and jumping.
 */
public class PlatformInputProcessor extends GameInputProcessor {
    public PlatformInputProcessor(final App app) {
        super(app);
    }

    @Override
    public boolean keyDown(int keycode) {
        super.keyDown(keycode);

        if (keycode == Hotkeys.UP || keycode == Hotkeys.UP_ALTERNATIVE) {
            ((GameScreen) app.getScreen()).getWorld().getPlayerUnit().jump();
        }
        if (keycode == Hotkeys.RIGHT || keycode == Hotkeys.RIGHT_ALTERNATIVE) {
            ((GameScreen) app.getScreen()).getWorld().getPlayerUnit().moveRight();
        }
        if (keycode == Hotkeys.LEFT || keycode == Hotkeys.LEFT_ALTERNATIVE) {
            ((GameScreen) app.getScreen()).getWorld().getPlayerUnit().moveLeft();
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        super.keyUp(keycode);

        if (keycode == Hotkeys.RIGHT || keycode == Hotkeys.RIGHT_ALTERNATIVE) {
            ((GameScreen) app.getScreen()).getWorld().getPlayerUnit().stopRight();
        }
        if (keycode == Hotkeys.LEFT || keycode == Hotkeys.LEFT_ALTERNATIVE) {
            ((GameScreen) app.getScreen()).getWorld().getPlayerUnit().stopLeft();
        }

        return false;
    }
}
