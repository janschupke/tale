package eu.janschupke.buddy.framework.input;

import com.badlogic.gdx.Gdx;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.config.Hotkeys;

/**
 * Base input processor for all top-down levels
 */
public class TopDownInputProcessor extends BaseInputProcessor {
    public TopDownInputProcessor(final App app) {
        super(app);
        Gdx.app.debug("TopDownInputProcessor#<init>", "Constructing");
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Hotkeys.UP || keycode == Hotkeys.UP_ALTERNATIVE) {
            ((GameScreen)app.getScreen()).getWorld().getPlayerUnit().moveUp();
        }
        // CTRL + S = sound toggle, needs to be excluded.
        if (keycode == Hotkeys.DOWN || (keycode == Hotkeys.DOWN_ALTERNATIVE && !app.getSettingsManager().getConfig().isCtrlDown())) {
            ((GameScreen)app.getScreen()).getWorld().getPlayerUnit().moveDown();
        }
        if (keycode == Hotkeys.RIGHT || keycode == Hotkeys.RIGHT_ALTERNATIVE) {
            ((GameScreen)app.getScreen()).getWorld().getPlayerUnit().moveRight();
        }
        if (keycode == Hotkeys.LEFT || keycode == Hotkeys.LEFT_ALTERNATIVE) {
            ((GameScreen)app.getScreen()).getWorld().getPlayerUnit().moveLeft();
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Hotkeys.UP || keycode == Hotkeys.UP_ALTERNATIVE) {
            ((GameScreen)app.getScreen()).getWorld().getPlayerUnit().stopUp();
        }
        if (keycode == Hotkeys.DOWN || keycode == Hotkeys.DOWN_ALTERNATIVE) {
            ((GameScreen)app.getScreen()).getWorld().getPlayerUnit().stopDown();
        }
        if (keycode == Hotkeys.RIGHT || keycode == Hotkeys.RIGHT_ALTERNATIVE) {
            ((GameScreen)app.getScreen()).getWorld().getPlayerUnit().stopRight();
        }
        if (keycode == Hotkeys.LEFT || keycode == Hotkeys.LEFT_ALTERNATIVE) {
            ((GameScreen)app.getScreen()).getWorld().getPlayerUnit().stopLeft();
        }

        return false;
    }
}
