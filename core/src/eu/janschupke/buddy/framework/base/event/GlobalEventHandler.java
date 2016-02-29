package eu.janschupke.buddy.framework.base.event;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import eu.janschupke.buddy.content.entity.PlayerUnit;
import eu.janschupke.buddy.content.ui.dialog.NewGameConfirmDialog;
import eu.janschupke.buddy.content.ui.menu.MainMenu;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.global.ToggleDialogsEvent;
import eu.janschupke.buddy.framework.base.event.global.ToggleMusicEvent;
import eu.janschupke.buddy.framework.base.event.global.ToggleSoundEvent;
import eu.janschupke.buddy.framework.base.screen.BaseScreen;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.ui.table.RootTable;
import eu.janschupke.buddy.framework.config.Config;
import eu.janschupke.buddy.framework.config.enumeration.Huds;
import eu.janschupke.buddy.framework.config.enumeration.Screens;
import eu.janschupke.buddy.framework.config.enumeration.WorldDebugRendering;
import eu.janschupke.buddy.framework.util.Utility;
import eu.janschupke.buddy.framework.util.WorldObjectFactory;
import eu.janschupke.buddy.logging.tools.GameLogParser;

import java.util.Map;

/**
 * Handler for all global events, such as the main menu actions.
 *
 * @author jan.schupke@gmail.com
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

    public GlobalEventHandler(final App app) {
        this.app = app;

        toggleMusicEvent = new ToggleMusicEvent(app);
        toggleSoundEvent = new ToggleSoundEvent(app);
        toggleDialogsEvent = new ToggleDialogsEvent(app);
    }

    /**
     * Dumps the current state of the game action log into XML file.
     */
    public void dumpData() {
        GameLogParser.parseToXml(app.getGameLog());
    }

    /**
     * TODO: not working.
     */
    public void toggleCollisionBypass() {
        if (!Config.DEBUG_MODE) {
            return;
        }

        Gdx.app.debug("GlobalEventHandler#toggleCollisionBypass", "Toggling collision bypass");

        Body playerBody = app.getGameState().getCurrentLevel().getWorld().getPlayerUnit().getBody();
        short collisionMask = (Config.BIT_OBSTACLE_ANY | Config.BIT_UNIT_ANY);
        short playerMask = playerBody.getFixtureList().get(0).getFilterData().maskBits;

        Gdx.app.debug("GlobalEventHandler#toggleCollisionBypass", String.format("mask: %d", collisionMask));
        Gdx.app.debug("GlobalEventHandler#toggleCollisionBypass", String.format("player: %d", playerMask));

        if (((GameScreen)app.getScreen()).getWorld().getPlayerUnit() instanceof PlayerUnit) {
            System.out.println("sdffds");
        }
        WorldObjectFactory.setCollisions(playerBody, Config.BIT_NOTHING, Config.BIT_NOTHING);
//        if (playerMask != collisionMask) {
//            Gdx.app.debug("GlobalEventHandler#toggleCollisionBypass", "Enabling collisions");
//            WorldObjectFactory.setCollisions(playerBody, Config.BIT_UNIT_ANY, collisionMask);
//        } else {
//            Gdx.app.debug("GlobalEventHandler#toggleCollisionBypass", "Disabling collisions");
//            WorldObjectFactory.setCollisions(playerBody, Config.BIT_NOTHING, Config.BIT_NOTHING);
//        }

//        if (app.getSettingsManager().getConfig().isCollisionBypass()) {
//            Gdx.app.debug("GlobalEventHandler#toggleCollisionBypass", "Enabling collisions");
//            app.getSettingsManager().getConfig().setCollisionBypass(false);
//            WorldObjectFactory.setCollisions(playerBody, Config.BIT_UNIT_ANY, collisionMask);
//            playerBody.getFixtureList().get(0).getFilterData().groupIndex = 0;
//        } else {
//            Gdx.app.debug("GlobalEventHandler#toggleCollisionBypass", "Disabling collisions");
//            app.getSettingsManager().getConfig().setCollisionBypass(true);
//            WorldObjectFactory.setCollisions(playerBody, Config.BIT_NOTHING, Config.BIT_NOTHING);
//            playerBody.getFixtureList().get(0).getFilterData().groupIndex = 2;
//        }
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
     */
    public void triggerMusic(boolean state) {
        Music backgroundMusic = ((BaseScreen) app.getScreen()).getBackgroundMusic();

        // Music might not be set at all.
        if (backgroundMusic == null) {
            return;
        }

        // Relevant only if music is enabled in configuration.
        if (!app.getSettingsManager().getConfig().isEnableMusic()) {
            backgroundMusic.stop();
            return;
        }

        adjustMusicVolume();
        backgroundMusic.setLooping(true);

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
            fireNewGame();
        }
    }

    /**
     * Transitions to the beginning screen.
     */
    public void fireNewGame() {
        Utility.transitionScreens(app, app.getScreenInstance(Config.FIRST_LEVEL), app.getHud(Huds.STANDARD));
        // Add continue game button.
        ((MainMenu) app.getHud(Huds.MAINMENU)).setupWidgets(true);
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
