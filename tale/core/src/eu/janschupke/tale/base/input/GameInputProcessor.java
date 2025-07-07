package eu.janschupke.tale.base.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;
import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.exception.NoHudException;
import eu.janschupke.tale.base.interaction.InteractionSwitch;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.base.screen.GameScreen;
import eu.janschupke.tale.content.config.Hotkeys;
import eu.janschupke.tale.content.ui.hud.main.StandardHud;

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

        if (keycode == Hotkeys.PAUSE) {
            app.getEventHandler().togglePause();
        }

        handleMenu(keycode);
        handleEnter(keycode);
        handleHud(keycode);

        return false;
    }

    /**
     * Handles hotkey menu toggling.
     * @param keycode Code of the pressed key.
     */
    private void handleMenu(int keycode) {
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
    }

    /**
     * Handles all events that need to happen after an enter press.
     * @param keycode Code of the pressed key.
     */
    private void handleEnter(int keycode) {
        if (keycode == Input.Keys.ENTER) {
            try {
                // Enter serves as a hotkey for tab closing.
                if (app.getHud().getState() != StandardHud.State.HUD) {
                    app.getHud().closeTabs();
                    // It also selects the first decision, if interaction is in progress.
                } else if (app.getGameState().getGlobalLevelState().isInteractionActive()) {
                    InteractionSwitch.getTriggerable().getInteraction().handle();
                } else if (InteractionSwitch.isInteractionPossible()) {
                    InteractionSwitch.getInteractionEvent().trigger();
                }
            } catch (NoHudException e) {
                Gdx.app.debug("GameInputProcessor#closeButton#keyDown", "Could not get HUD instance");
            }
        }
    }

    /**
     * Handles the toggling of HUD panels.
     * @param keycode Code of the pressed key.
     */
    private void handleHud(int keycode) {
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
            if (app.getGameState().getGlobalLevelState().isInteractionActive()) {
                InteractionSwitch.getTriggerable().endInteraction(app);
            } else if (InteractionSwitch.isInteractionPossible()) {
                InteractionSwitch.getInteractionEvent().trigger();
            }
        }
    }

    @Override
    public boolean keyUp(int keycode) {
        // This is a mystery. :3
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
