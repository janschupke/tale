package eu.janschupke.tale.base.event.handling;

import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.config.enumeration.WorldDebugRendering;
import eu.janschupke.tale.base.interaction.InteractionSwitch;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.base.screen.GameScreen;
import eu.janschupke.tale.base.ui.table.RootTable;
import eu.janschupke.tale.base.utility.Utility;
import eu.janschupke.tale.content.config.Config;
import eu.janschupke.tale.content.config.enumeration.Huds;
import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.content.event.NewGameGeneralEvent;
import eu.janschupke.tale.content.event.ToggleDialogsEvent;
import eu.janschupke.tale.content.event.ToggleMusicEvent;
import eu.janschupke.tale.content.event.ToggleSoundEvent;
import eu.janschupke.tale.content.ui.dialog.NewGameConfirmDialog;
import eu.janschupke.tale.content.ui.menu.MainMenu;
import eu.janschupke.tale.logging.utility.GameLogParser;

/**
 * Handles global game events.
 * Manages system-wide events and notifications.
 */
public class GlobalEventHandler {
    private final App app;

    /**
     * Global event that toggles music playback on/off.
     */
    private ToggleMusicEvent toggleMusicEvent;

    /**
     * Global event that toggles all sound effects on/off.
     */
    private ToggleSoundEvent toggleSoundEvent;

    /**
     * Global event that toggles event dialog display.
     */
    private ToggleDialogsEvent toggleDialogsEvent;

    /**
     * Logs an entry whenever a new game is requested.
     */
    private NewGameGeneralEvent newGameGeneralEvent;

    public GlobalEventHandler(final App app) {
        this.app = app;

        toggleMusicEvent = new ToggleMusicEvent(app);
        toggleSoundEvent = new ToggleSoundEvent(app);
        toggleDialogsEvent = new ToggleDialogsEvent(app);
        newGameGeneralEvent = new NewGameGeneralEvent(app);
    }

    /**
     * Handles the display of the hint message according to the current game state.
     */
    public void handleHintMessage() {
        // Hint is available only in game screens.
        if (!(app.getScreen() instanceof GameScreen)) {
            return;
        }

        GameScreen screen = (GameScreen) app.getScreen();

        // Paused notification when game is paused.
        if (screen.isPaused()) {
            app.getGameState().getGlobalLevelState().setCurrentHint(app.getLang().get("hint.global.paused"));
            return;
        }

        // No hint during interactions.
        if (app.getGameState().getGlobalLevelState().isInteractionActive()) {
            app.getGameState().getGlobalLevelState().clearCurrentHint();
            return;
        }

        // Interaction hint when available.
        if (InteractionSwitch.isInteractionPossible() && InteractionSwitch.getTriggerable().getInteraction() != null) {
            app.getGameState().getGlobalLevelState().setCurrentHint(
                    InteractionSwitch.getTriggerable().getInteractionHint());
            return;
        }

        // Nothing otherwise.
        app.getGameState().getGlobalLevelState().clearCurrentHint();
    }

    /**
     * Toggles debug rendering for all Scene2D tables in the game.
     *
     * @param state Requested debug state.
     */
    public void toggleUiDebug(boolean state) {
        Gdx.app.debug("GlobalEventHandler#toggleUiDebug", "Calling debug toggle");
        for (Map.Entry<Huds, RootTable> entry : app.getHuds().entrySet()) {
            toggleTableDebug(entry.getValue(), state);
        }
    }

    /**
     * Toggles debug mode for the provided UI table
     * and all inner tables it contains.
     *
     * @param table Target table.
     * @param state New debug state.
     */
    private void toggleTableDebug(Table table, boolean state) {
        table.setDebug(state);

        for (Actor actor : table.getChildren()) {
            actor.setDebug(state);
            if (actor instanceof Table) {
                toggleTableDebug((Table) actor, state);
            }
        }
    }

    /**
     * Triggers background music playback based on current configuration.
     *
     * @param state Attempts to play if true, stop otherwise.
     * @param loop If true, music will be looped. If false, music will only play once.
     */
    public void triggerMusic(boolean state, boolean loop) {
        Gdx.app.debug("GlobalEventHandler#triggerMusic", "Triggering");
        Music backgroundMusic = ((BaseScreen) app.getScreen()).getBackgroundMusic();

        // Music might not be set at all.
        if (backgroundMusic == null) {
            return;
        }

        // Relevant only if music is enabled in configuration.
        if (!app.getSettingsManager().getConfig().isEnableMusic()) {
            Gdx.app.debug("GlobalEventHandler#triggerMusic", "Stopping");
            backgroundMusic.stop();
            return;
        }

        adjustMusicVolume();
        backgroundMusic.setLooping(loop);

        // Toggle based on the current playback state.
        if (state) {
            if (!backgroundMusic.isPlaying()) {
                backgroundMusic.play();
            }
        } else {
            backgroundMusic.stop();
        }
    }

    /**
     * Adjusts the volume of currently playing background music
     * based on the configuration volume value.
     */
    public void adjustMusicVolume() {
        Gdx.app.debug("GlobalEventHandler#adjustMusicVolume", "Adjusting");
        ((BaseScreen) app.getScreen()).getBackgroundMusic().setVolume(app.getSettingsManager().getConfig().getMasterVolume() *
                app.getSettingsManager().getConfig().getMusicVolume());
    }

    /**
     * Toggles current screen's background music.
     */
    public void toggleMusic() {
        toggleMusicEvent.trigger();
        // Toggle the playback itself.
        triggerMusic(app.getSettingsManager().getConfig().isEnableMusic(), true);
    }

    /**
     * Toggles all sounds on and off.
     */
    public void toggleSound() {
        toggleSoundEvent.trigger();
    }

    /**
     * Toggles the UI table debug rendering.
     */
    public void toggleUiDebugRendering() {
        if (!Config.DEBUG_MODE) return;
        Gdx.app.debug("GlobalEventHandler#toggleUiDebugRendering", "Toggling UI debug");
        boolean current = app.getSettingsManager().getConfig().isUiDebugRendering();
        app.getSettingsManager().getConfig().setUiDebugRendering(!current);
        toggleUiDebug(!current);
    }

    /**
     * Toggles world's texture and physics debug rendering.
     */
    public void toggleWorldDebugRendering() {
        if (!Config.DEBUG_MODE) return;
        Gdx.app.debug("GlobalEventHandler#toggleWorldDebugRendering", "Toggling world debug");

        switch (app.getSettingsManager().getConfig().getWorldDebugRendering()) {
            case DEBUG:
                app.getSettingsManager().getConfig().setWorldDebugRendering(WorldDebugRendering.GRAPHICS);
                break;
            case GRAPHICS:
                app.getSettingsManager().getConfig().setWorldDebugRendering(WorldDebugRendering.ALL);
                break;
            default:
            case ALL:
                app.getSettingsManager().getConfig().setWorldDebugRendering(WorldDebugRendering.DEBUG);
                break;
        }
    }

    /**
     * Toggles the modal dialog-showing state.
     * Event log entries will appear regardless of this toggle.
     */
    public void toggleDialogs() {
        toggleDialogsEvent.trigger();
    }

    /**
     * Displays main menu, or level menu, depending on the current game state.
     */
    public void showMainMenu() {
        if (app.getScreen() == app.getScreenInstance(Screens.MENU)) {
            Utility.transitionHuds(app, app.getHud(Huds.MAINMENU));
        } else {
            Utility.transitionHuds(app, app.getHud(Huds.GAMEMENU));
        }
    }

    public void showGameMenu() {
        Utility.transitionHuds(app, app.getHud(Huds.GAMEMENU));
    }

    /**
     * Toggles between game screen's pause states.
     */
    public void togglePause() {
        if (((GameScreen) app.getScreen()).isPaused()) {
            app.getScreen().resume();
            return;
        }

        app.getScreen().pause();
    }

    /**
     * Called when game is finished and player needs to exit the outro screen.
     */
    public void endGame() {
        Gdx.app.debug("GlobalEventHandler#endGame", "Ending Game");
        GameLogParser.parseToXml(app.getGameLog());
        app.resetState();
        app.getScreen().resume();
        Utility.transitionScreens(app, app.getScreenInstance(Screens.MENU), app.getHud(Huds.MAINMENU));
    }

    /**
     * Starts a new game, discards old state
     * if exists and the action is confirmed by the user.
     */
    public void startNewGame() {
        Gdx.app.debug("GlobalEventHandler#startNewGame", "New Game");
        // Reset confirmation dialog and the reset itself, but only when needed.
        if (app.getGameState().getCurrentLevel() != null) {
            Gdx.app.debug("GlobalEventHandler#startNewGame", "Reset confirm");
            new NewGameConfirmDialog(app).show(app.getUi());
        } else {
            GameLogParser.parseToXml(app.getGameLog());
            fireNewGame();
        }
    }

    /**
     * Transitions to the beginning screen.
     */
    public void fireNewGame() {
        InteractionSwitch.disable(app);
        Utility.transitionScreens(app, app.getScreenInstance(Config.FIRST_LEVEL), app.getHud(Huds.STANDARD));
        // Add continue game button.
        ((MainMenu) app.getHud(Huds.MAINMENU)).setupWidgets(true);
        newGameGeneralEvent.trigger();
    }

    /**
     * Returns to the currently ongoing game.
     */
    public void continueGame() {
        Gdx.app.debug("GlobalEventHandler#continueGame", "Continue Game");
        Utility.transitionScreens(app, app.getGameState().getCurrentLevel(), app.getHud(Huds.STANDARD));
        app.getScreen().resume();
    }

    /**
     * Displays settings GUI table.
     */
    public void showSettings() {
        Gdx.app.debug("GlobalEventHandler#showSettings", "Show Settings");
        Utility.transitionHuds(app, app.getHud(Huds.SETTINGSMENU));
    }

    /**
     * Displays graphics settings table.
     */
    public void showGraphicsMenu() {
        Utility.transitionHuds(app, app.getHud(Huds.GRAPHICSMENU));
    }

    /**
     * Display audio settings table.
     */
    public void showAudioMenu() {
        Utility.transitionHuds(app, app.getHud(Huds.AUDIOMENU));
    }

    /**
     * Displays hotkeys list GUI.
     */
    public void showHotkeys() {
        Gdx.app.debug("GlobalEventHandler#showHotkeys", "Show Hotkeys");
        Utility.transitionHuds(app, app.getHud(Huds.HOTKEYSMENU));
    }

    /**
     * Displays game's credits table.
     */
    public void showCredits() {
        Gdx.app.debug("GlobalEventHandler#showCredits", "Show Credits");
        Utility.transitionHuds(app, app.getHud(Huds.CREDITSMENU));
    }

    /**
     * Leaves the current level and enters the main menu screen.
     */
    public void leaveLevel() {
        Utility.transitionScreens(app, app.getScreenInstance(Screens.MENU), app.getHud(Huds.MAINMENU));
    }

    /**
     * Persists configuration to file and exits the game.
     */
    public void exitGame() {
        app.getSettingsManager().persist();
        Gdx.app.debug("GlobalEventHandler#exitGame", "Exit Game");
        Gdx.app.exit();
    }
}
