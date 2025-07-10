package eu.janschupke.tale.base.input;

import com.badlogic.gdx.Gdx;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.screen.GameScreen;
import eu.janschupke.tale.content.config.Hotkeys;

/**
 * Input processor for top-down game screens.
 * Handles 4-directional movement and interactions.
 */
public class TopDownInputProcessor extends GameInputProcessor {
    public TopDownInputProcessor(final App app) {
        super(app);
        Gdx.app.debug("TopDownInputProcessor#<init>", "Constructing");
    }

    @Override
    public boolean keyDown(int keycode) {
        if (!(app.getScreen() instanceof GameScreen)) {
            return false;
        }

        super.keyDown(keycode);

        if (keycode == Hotkeys.UP || keycode == Hotkeys.UP_ALTERNATIVE) {
            ((GameScreen) app.getScreen()).getWorld().getPlayerUnit().moveUp();
        }
        // CTRL + S = sound toggle, needs to be excluded.
        if (keycode == Hotkeys.DOWN || (keycode == Hotkeys.DOWN_ALTERNATIVE && !app.getSettingsManager().getConfig().isCtrlDown())) {
            ((GameScreen) app.getScreen()).getWorld().getPlayerUnit().moveDown();
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
        if (!(app.getScreen() instanceof GameScreen)) {
            return false;
        }

        super.keyUp(keycode);

        if (keycode == Hotkeys.UP || keycode == Hotkeys.UP_ALTERNATIVE) {
            ((GameScreen) app.getScreen()).getWorld().getPlayerUnit().stopUp();
        }
        // CTRL + S = sound toggle, needs to be excluded.
        if (keycode == Hotkeys.DOWN || (keycode == Hotkeys.DOWN_ALTERNATIVE && !app.getSettingsManager().getConfig().isCtrlDown())) {
            ((GameScreen) app.getScreen()).getWorld().getPlayerUnit().stopDown();
        }
        if (keycode == Hotkeys.RIGHT || keycode == Hotkeys.RIGHT_ALTERNATIVE) {
            ((GameScreen) app.getScreen()).getWorld().getPlayerUnit().stopRight();
        }
        if (keycode == Hotkeys.LEFT || keycode == Hotkeys.LEFT_ALTERNATIVE) {
            ((GameScreen) app.getScreen()).getWorld().getPlayerUnit().stopLeft();
        }

        return false;
    }
}
