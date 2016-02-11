package eu.janschupke.buddy.framework.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;
import eu.janschupke.buddy.framework.base.screen.BaseScreen;
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
        super.keyDown(keycode);

        if (keycode == Hotkeys.PAUSE) {
            app.getEventHandler().togglePause();
        }
        if (keycode == Hotkeys.MENU || keycode == Hotkeys.MENU_ALTERNATIVE) {
            Gdx.app.debug("GameInputProcessor#keyDown", "Toggling menu");
            ((GameScreen)app.getScreen()).toggleMenu();
        }
        if (keycode == Hotkeys.EVENTS) {
            ((GameScreen)app.getScreen()).toggleEventLog();
        }
        if (keycode == Hotkeys.QUESTS) {
            ((GameScreen)app.getScreen()).toggleQuestLog();
        }
        if (keycode == Hotkeys.INVENTORY) {
            ((GameScreen)app.getScreen()).toggleInventory();
        }
        if (keycode == Hotkeys.DIALOGS) {
            Gdx.app.debug("GameInputProcessor#keyDown", "Firing dialog toggle");
            app.getEventHandler().toggleDialogs();
        }
        if (keycode == Hotkeys.INTERACT) {
            Gdx.app.debug("GameInputProcessor#keyDown", "Firing interact");
            if (InteractionSwitch.isInteractionPossible()) {
                InteractionSwitch.getInteractionEvent().trigger();
            }
        }

        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);

        try {
            // This streamlines entity positioning within the world.
            Vector3 position = ((BaseScreen)app.getScreen()).getView().getCamera().unproject(new Vector3(screenX, screenY, 0));
            Gdx.app.debug("GameInputProcessor#touchDown", String.format("Position: [%.0f, %.0f]", position.x, position.y));
        } catch (NullPointerException e) {}

        return false;
    }
}
