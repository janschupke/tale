package eu.janschupke.buddy.framework.input;

import com.badlogic.gdx.Gdx;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.config.Hotkeys;

/**
 * Generic processor for all level type game states.
 */
public class GameInputProcessor extends BaseInputProcessor {
    public GameInputProcessor(final App app) {
        super(app);
        Gdx.app.debug("GameInputProcessor#<init>", "Constructing");
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Hotkeys.MENU || keycode == Hotkeys.MENU_ALTERNATIVE) {
            Gdx.app.debug("GameInputProcessor#keyDown", "Toggling menu");
            ((GameScreen)app.getScreen()).toggleMenu();
        }
        if (keycode == Hotkeys.INTERACT) {
            Gdx.app.debug("GameInputProcessor#keyDown", "Firing interact");
            // TODO
        }
        // CTRL + M = music toggle, needs to be excluded.
        if (keycode == Hotkeys.MAP  && !app.getSettingsManager().getConfig().isCtrlDown()) {
            Gdx.app.debug("GameInputProcessor#keyDown", "Toggling map");
            ((GameScreen)app.getScreen()).toggleMap();
        }
        if (keycode == Hotkeys.INVENTORY) {
            Gdx.app.debug("GameInputProcessor#keyDown", "Toggling inventory");
            ((GameScreen)app.getScreen()).toggleInventory();
        }
        if (keycode == Hotkeys.CHARACTER) {
            Gdx.app.debug("GameInputProcessor#keyDown", "Toggling character");
            ((GameScreen)app.getScreen()).toggleCharacter();
        }
        if (keycode == Hotkeys.EVENT_LOG) {
            Gdx.app.debug("GameInputProcessor#keyDown", "Toggling event log");
            ((GameScreen)app.getScreen()).toggleEventLog();
        }
        if (keycode == Hotkeys.QUEST_LOG) {
            Gdx.app.debug("GameInputProcessor#keyDown", "Toggling quest log");
            ((GameScreen)app.getScreen()).toggleQuestLog();
        }

        return false;
    }
}
