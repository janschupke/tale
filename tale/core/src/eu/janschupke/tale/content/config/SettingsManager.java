package eu.janschupke.tale.content.config;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import eu.janschupke.tale.base.config.ConfigManager;

/**
 * Configuration manager class that handles loading, saving and resetting the configuration.
 *
 * @author jan.schupke@gmail.com
 */
public class SettingsManager implements ConfigManager {
    protected Preferences settingsPrefs;
    protected RunningConfig config;

    public SettingsManager() {
        settingsPrefs = Gdx.app.getPreferences(Config.GAME_PREFIX + "-" + Config.PREFERENCES_SETTINGS);
        config = new RunningConfig();

        load();
    }

    @Override
    public void persist() {
        settingsPrefs.putInteger(SettingsKeys.GRAPHICS_RESOLUTION_INDEX, config.getResolutionIndex());
        settingsPrefs.putInteger(SettingsKeys.GRAPHICS_SCREEN_WIDTH, config.getScreenWidth());
        settingsPrefs.putInteger(SettingsKeys.GRAPHICS_SCREEN_HEIGHT, config.getScreenHeight());
        settingsPrefs.putBoolean(SettingsKeys.GRAPHICS_FULLSCREEN, config.isFullscreen());

        settingsPrefs.putFloat(SettingsKeys.AUDIO_MASTER, config.getMasterVolume());
        settingsPrefs.putFloat(SettingsKeys.AUDIO_MUSIC, config.getMusicVolume());
        settingsPrefs.putFloat(SettingsKeys.AUDIO_SFX, config.getSoundVolume());
        settingsPrefs.putFloat(SettingsKeys.AUDIO_SPEECH, config.getSpeechVolume());
        settingsPrefs.putBoolean(SettingsKeys.AUDIO_ENABLE_MUSIC, config.isEnableMusic());
        settingsPrefs.putBoolean(SettingsKeys.AUDIO_ENABLE_SOUND, config.isEnableSound());

        settingsPrefs.putInteger(SettingsKeys.GAMEPLAY_FG_FPS, config.getForegroundFps());
        settingsPrefs.putInteger(SettingsKeys.GAMEPLAY_BG_FPS, config.getBackgroundFps());
        settingsPrefs.putBoolean(SettingsKeys.GAMEPLAY_ENABLE_DIALOGS, config.isEnableDialogs());

        settingsPrefs.putBoolean(SettingsKeys.DEBUG_UI, config.isUiDebugRendering());
        settingsPrefs.flush();
    }

    @Override
    public void load() {
        config.setResolutionIndex(settingsPrefs.getInteger(SettingsKeys.GRAPHICS_RESOLUTION_INDEX, DefaultSettings.RESOLUTION_INDEX));
        config.setScreenWidth(settingsPrefs.getInteger(SettingsKeys.GRAPHICS_SCREEN_WIDTH, DefaultSettings.SCREEN_WIDTH));
        config.setScreenHeight(settingsPrefs.getInteger(SettingsKeys.GRAPHICS_SCREEN_HEIGHT, DefaultSettings.SCREEN_HEIGHT));
        config.setFullscreen(settingsPrefs.getBoolean(SettingsKeys.GRAPHICS_FULLSCREEN, DefaultSettings.FULLSCREEN));

        config.setMasterVolume(settingsPrefs.getFloat(SettingsKeys.AUDIO_MASTER, DefaultSettings.MASTER_VOLUME));
        config.setMusicVolume(settingsPrefs.getFloat(SettingsKeys.AUDIO_MUSIC, DefaultSettings.MUSIC_VOLUME));
        config.setSoundVolume(settingsPrefs.getFloat(SettingsKeys.AUDIO_SFX, DefaultSettings.SOUND_VOLUME));
        config.setSpeechVolume(settingsPrefs.getFloat(SettingsKeys.AUDIO_SPEECH, DefaultSettings.SPEECH_VOLUME));
        config.setEnableMusic(settingsPrefs.getBoolean(SettingsKeys.AUDIO_ENABLE_MUSIC, DefaultSettings.ENABLE_MUSIC));
        config.setEnableSound(settingsPrefs.getBoolean(SettingsKeys.AUDIO_ENABLE_SOUND, DefaultSettings.ENABLE_SOUND));

        config.setForegroundFps(settingsPrefs.getInteger(SettingsKeys.GAMEPLAY_FG_FPS, DefaultSettings.FOREGROUND_FPS));
        config.setBackgroundFps(settingsPrefs.getInteger(SettingsKeys.GAMEPLAY_BG_FPS, DefaultSettings.BACKGROUND_FPS));
        config.setEnableDialogs(settingsPrefs.getBoolean(SettingsKeys.GAMEPLAY_ENABLE_DIALOGS, DefaultSettings.ENABLE_DIALOGS));

        config.setUiDebugRendering(settingsPrefs.getBoolean(SettingsKeys.DEBUG_UI, DefaultSettings.DEBUG_UI));
    }

    @Override
    public void reset() {
        config.setResolutionIndex(DefaultSettings.RESOLUTION_INDEX);
        config.setScreenWidth(DefaultSettings.SCREEN_WIDTH);
        config.setScreenHeight(DefaultSettings.SCREEN_HEIGHT);
        config.setFullscreen(DefaultSettings.FULLSCREEN);

        config.setMasterVolume(DefaultSettings.MASTER_VOLUME);
        config.setMusicVolume(DefaultSettings.MUSIC_VOLUME);
        config.setSoundVolume(DefaultSettings.SOUND_VOLUME);
        config.setSpeechVolume(DefaultSettings.SPEECH_VOLUME);
        config.setEnableMusic(DefaultSettings.ENABLE_MUSIC);
        config.setEnableSound(DefaultSettings.ENABLE_SOUND);

        config.setForegroundFps(DefaultSettings.FOREGROUND_FPS);
        config.setBackgroundFps(DefaultSettings.BACKGROUND_FPS);
        config.setEnableDialogs(DefaultSettings.ENABLE_DIALOGS);

        config.setUiDebugRendering(DefaultSettings.DEBUG_UI);

        persist();
    }

    public RunningConfig getConfig() {
        return config;
    }
}
