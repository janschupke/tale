package eu.janschupke.buddy.framework.base.event;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import eu.janschupke.buddy.content.ui.menu.MainMenu;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.global.ToggleDialogsEvent;
import eu.janschupke.buddy.framework.base.event.global.ToggleMusicEvent;
import eu.janschupke.buddy.framework.base.event.global.ToggleSoundEvent;
import eu.janschupke.buddy.framework.base.screen.BaseScreen;
import eu.janschupke.buddy.framework.base.ui.table.RootTable;
import eu.janschupke.buddy.framework.config.Config;
import eu.janschupke.buddy.framework.util.Utility;

import java.util.Map;

/**
 * Handler for all global events, such as the main menu actions.
 */
public class GlobalEventHandler {
    private final App app;

    private ToggleMusicEvent toggleMusicEvent;
    private ToggleSoundEvent toggleSoundEvent;
    private ToggleDialogsEvent toggleDialogsEvent;

    public GlobalEventHandler(final App app) {
        this.app = app;

        toggleMusicEvent = new ToggleMusicEvent(app);
        toggleSoundEvent = new ToggleSoundEvent(app);
        toggleDialogsEvent = new ToggleDialogsEvent(app);
    }

    /**
     * Toggles debug rendering for all Scene2D tables in the game.
     * @param state Requested debug state.
     */
    public void toggleUiDebug(boolean state) {
        Gdx.app.debug("GlobalEventHandler#toggleUiDebug", "Calling debug toggle");
        for(Map.Entry<Config.Huds, RootTable> entry : app.getHuds().entrySet()) {
            toggleTableDebug(entry.getValue(), state);
        }
    }

    /**
     * Toggles debug mode for the provided UI table
     * and all inner tables it contains.
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
     * @param state Attempts to play if true, stop otherwise.
     */
    public void triggerMusic(boolean state) {
        Music backgroundMusic = ((BaseScreen)app.getScreen()).getBackgroundMusic();

        if (backgroundMusic == null) {
            return;
        }

        if (!app.getSettingsManager().getConfig().isEnableMusic()) {
            backgroundMusic.stop();
            return;
        }

        adjustMusicVolume();
        backgroundMusic.setLooping(true);

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
        triggerMusic(app.getSettingsManager().getConfig().isEnableMusic());
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
                app.getSettingsManager().getConfig().setWorldDebugRendering(Config.WorldDebugRendering.GRAPHICS);
                break;
            case GRAPHICS:
                app.getSettingsManager().getConfig().setWorldDebugRendering(Config.WorldDebugRendering.ALL);
                break;
            default:
            case ALL:
                app.getSettingsManager().getConfig().setWorldDebugRendering(Config.WorldDebugRendering.DEBUG);
                break;
        }
    }

    /**
     * Toggles the modal dialog-showing state.
     * Event log entries will appear regardless of this toggle.
     */
    public void toggleDialogs() {
        boolean current = app.getSettingsManager().getConfig().isEnableDialogs();
        app.getSettingsManager().getConfig().setEnableDialogs(!current);
        toggleDialogsEvent.trigger();
    }

    /**
     * Displays main menu, or level menu, depending on the current game state.
     */
    public void showMainMenu() {
        if (app.getScreen() == app.getScreenInstance(Config.Screens.MENU)) {
            Utility.transitionHuds(app, app.getHud(Config.Huds.MAINMENU));
        } else {
            Utility.transitionHuds(app, app.getHud(Config.Huds.GAMEMENU));
        }
    }

    public void showGameMenu() {
        Utility.transitionHuds(app, app.getHud(Config.Huds.GAMEMENU));
    }

    public void startNewGame() {
        Gdx.app.debug("GlobalEventHandler#startNewGame", "New Game");
        // TODO: only reset if needed, also add confirm dialog.
        app.resetState();
        Utility.transitionScreens(app, app.getScreenInstance(Config.FIRST_LEVEL), app.getHud(Config.Huds.STANDARD));
        // Add continue game button.
        ((MainMenu)app.getHud(Config.Huds.MAINMENU)).setupWidgets(true);
    }

    public void continueGame() {
        Gdx.app.debug("GlobalEventHandler#continueGame", "Continue Game");
        Utility.transitionScreens(app, app.getGameState().getCurrentLevel(), app.getHud(Config.Huds.STANDARD));
        app.getScreen().resume();
    }

    public void showSettings() {
        Gdx.app.debug("GlobalEventHandler#showSettings", "Show Settings");
        Utility.transitionHuds(app, app.getHud(Config.Huds.SETTINGSMENU));
    }

    public void showGraphicsMenu() {
        Utility.transitionHuds(app, app.getHud(Config.Huds.GRAPHICSMENU));
    }

    public void showAudioMenu() {
        Utility.transitionHuds(app, app.getHud(Config.Huds.AUDIOMENU));
    }

    public void showHotkeys() {
        Gdx.app.debug("GlobalEventHandler#showHotkeys", "Show Hotkeys");
        Utility.transitionHuds(app, app.getHud(Config.Huds.HOTKEYSMENU));
    }

    public void showCredits() {
        Gdx.app.debug("GlobalEventHandler#showCredits", "Show Credits");
        Utility.transitionHuds(app, app.getHud(Config.Huds.CREDITSMENU));
    }

    public void leaveLevel() {
        Utility.transitionScreens(app, app.getScreenInstance(Config.Screens.MENU), app.getHud(Config.Huds.MAINMENU));
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
