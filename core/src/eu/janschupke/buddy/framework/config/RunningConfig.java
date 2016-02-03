package eu.janschupke.buddy.framework.config;

/**
 * All global configuration values loaded from the preferences.
 */
public class RunningConfig {
    private boolean ctrlDown;
    private boolean uiDebugRendering = Config.DEFAULT_UI_DEBUG_RENDERING;
    private Config.WorldDebugRendering worldDebugRendering = Config.DEFAULT_WORLD_DEBUG_RENDERING;

    private int resolutionIndex;
    private int screenWidth;
    private int screenHeight;
    private boolean fullscreen;

    private float masterVolume;
    private float musicVolume;
    private float soundVolume;
    private float speechVolume;
    private boolean enableMusic;
    private boolean enableSound;

    private boolean showHints;
    private int foregroundFps;
    private int backgroundFps;

    public boolean isCtrlDown() {
        return ctrlDown;
    }

    public void setCtrlDown(boolean ctrlDown) {
        this.ctrlDown = ctrlDown;
    }

    public boolean isUiDebugRendering() {
        return uiDebugRendering;
    }

    public void setUiDebugRendering(boolean uiDebugRendering) {
        this.uiDebugRendering = uiDebugRendering;
    }

    public Config.WorldDebugRendering getWorldDebugRendering() {
        return worldDebugRendering;
    }

    public void setWorldDebugRendering(Config.WorldDebugRendering worldDebugRendering) {
        this.worldDebugRendering = worldDebugRendering;
    }

    public int getResolutionIndex() {
        return resolutionIndex;
    }

    public void setResolutionIndex(int resolutionIndex) {
        this.resolutionIndex = resolutionIndex;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public boolean isFullscreen() {
        return fullscreen;
    }

    public void setFullscreen(boolean fullscreen) {
        this.fullscreen = fullscreen;
    }

    public float getMasterVolume() {
        return masterVolume;
    }

    public void setMasterVolume(float masterVolume) {
        this.masterVolume = masterVolume;
    }

    public float getMusicVolume() {
        return musicVolume;
    }

    public void setMusicVolume(float musicVolume) {
        this.musicVolume = musicVolume;
    }

    public float getSoundVolume() {
        return soundVolume;
    }

    public void setSoundVolume(float soundVolume) {
        this.soundVolume = soundVolume;
    }

    public float getSpeechVolume() {
        return speechVolume;
    }

    public void setSpeechVolume(float speechVolume) {
        this.speechVolume = speechVolume;
    }

    public boolean isEnableMusic() {
        return enableMusic;
    }

    public void setEnableMusic(boolean enableMusic) {
        this.enableMusic = enableMusic;
    }

    public boolean isEnableSound() {
        return enableSound;
    }

    public void setEnableSound(boolean enableSound) {
        this.enableSound = enableSound;
    }

    public boolean isShowHints() {
        return showHints;
    }

    public void setShowHints(boolean showHints) {
        this.showHints = showHints;
    }

    public int getForegroundFps() {
        return foregroundFps;
    }

    public void setForegroundFps(int foregroundFps) {
        this.foregroundFps = foregroundFps;
    }

    public int getBackgroundFps() {
        return backgroundFps;
    }

    public void setBackgroundFps(int backgroundFps) {
        this.backgroundFps = backgroundFps;
    }
}
