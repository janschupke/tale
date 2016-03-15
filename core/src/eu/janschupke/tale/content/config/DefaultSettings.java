package eu.janschupke.tale.content.config;

import eu.janschupke.tale.base.config.enumeration.WorldDebugRendering;

/**
 * Default settings values.
 *
 * @author jan.schupke@gmail.com
 */
public class DefaultSettings {
    public static final int RESOLUTION_INDEX = 0;
    public static final int SCREEN_WIDTH = Config.AVAILABLE_WIDTHS[0];
    public static final int SCREEN_HEIGHT = Config.AVAILABLE_HEIGHTS[0];
    public static final boolean FULLSCREEN = false;

    public static final float MASTER_VOLUME = 0.5f;
    public static final float MUSIC_VOLUME = 0.1f;
    public static final float SOUND_VOLUME = 0.4f;
    public static final float SPEECH_VOLUME = 0.4f;
    public static final boolean ENABLE_MUSIC = true;
    public static final boolean ENABLE_SOUND = true;
    public static final boolean ENABLE_DIALOGS = true;

    public static final int FOREGROUND_FPS = 120;
    public static final int BACKGROUND_FPS = 30;

    public static final boolean DEBUG_UI = false;
    public static final WorldDebugRendering DEBUG_WORLD = WorldDebugRendering.GRAPHICS;
}
