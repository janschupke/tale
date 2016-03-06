package eu.janschupke.tale.framework.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import eu.janschupke.tale.content.config.Hotkeys;
import eu.janschupke.tale.content.ui.hud.StandardHud;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.exception.NoHudException;
import eu.janschupke.tale.framework.interaction.InteractionSwitch;
import eu.janschupke.tale.framework.screen.BaseScreen;
import eu.janschupke.tale.framework.screen.GameScreen;

/**
 * Generic processor for all level type game states.
 *
 * @author jan.schupke@gmail.com
 */
public class GameInputProcessor extends BaseInputProcessor {
    public GameInputProcessor(final App app) {
        super(app);
        Gdx.app.debug("GameInputProcessor#<init>", "Constructing");
    }

    @Override
    public boolean keyDown(int keycode) {
        if (!(app.getScreen() instanceof GameScreen)) {
            return false;
        }

        super.keyDown(keycode);

        if (keycode == Hotkeys.DEBUG_COLLISION_BYPASS) {
            app.getEventHandler().toggleCollisionBypass();
        }
        if (keycode == Hotkeys.PAUSE) {
            app.getEventHandler().togglePause();
        }
        // Close tabs, if any are open. Toggle menu if no tabs are active.
        if (keycode == Hotkeys.MENU || keycode == Hotkeys.MENU_ALTERNATIVE) {
            Gdx.app.debug("GameInputProcessor#keyDown", "Toggling menu");
            try {
                if (app.getHud().getState() != StandardHud.State.HUD) {
                    app.getHud().closeTabs();
                } else if (app.getGameState().getGlobalLevelState().isInteractionActive()) {
                    InteractionSwitch.getTriggerable().endInteraction(app);
                } else {
                    ((GameScreen) app.getScreen()).toggleMenu();
                }
            } catch (NoHudException e) {
                try {
                    ((GameScreen) app.getScreen()).toggleMenu();
                } catch (ClassCastException e2) {
                    Gdx.app.debug("GameInputProcessor#keyDown", "Not in game, cannot toggle menu");
                }
            }
        }
        if (keycode == Hotkeys.MESSAGES) {
            ((GameScreen) app.getScreen()).toggleEventLog();
        }
        if (keycode == Hotkeys.QUESTS) {
            ((GameScreen) app.getScreen()).toggleQuestLog();
        }
        if (keycode == Hotkeys.INVENTORY) {
            ((GameScreen) app.getScreen()).toggleInventory();
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
    public boolean keyUp(int keycode) {
        // FIXME: black magic of unknown origin...
        return (!(app.getScreen() instanceof GameScreen)) ? false : super.keyUp(keycode);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);

        try {
            // This streamlines entity positioning within the world.
            Vector3 position = ((BaseScreen) app.getScreen()).getView().getCamera().unproject(new Vector3(screenX, screenY, 0));
            Gdx.app.debug("GameInputProcessor#touchDown", String.format("Position: [%.0f, %.0f]", position.x, position.y));
        } catch (NullPointerException e) {
            Gdx.app.debug("GameInputProcessor#touchDown", "Coordinates are not available");
        }

        return false;
    }
}
