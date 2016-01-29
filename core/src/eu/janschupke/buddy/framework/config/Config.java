package eu.janschupke.buddy.framework.config;

import com.badlogic.gdx.math.Vector2;

/**
 * Default configuration and global constants.
 */
public class Config {
    // Global untranslated strings.
    public static final String GAME_PREFIX = "buddy";
    public static final String GAME_TITLE = "Buddy the Bachelor";
    public static final String PREFERENCES_SETTINGS = "settings";

    // Screen configuration.
    public static final boolean SCREEN_RESIZABLE = false;
    public static final float SCREEN_TRANSITION_DURATION = 0.1f;

    public static final String[] AVAILABLE_RESOLUTIONS = {
        "960x540 (16:9)", "1024x576 (16:9)", "1280x720 (16:9)", "1600x900 (16:9)", "1920x1080 (16:9)",
                "800x600 (4:3)", "1152x864 (4:3)", "1400x1050 (4:3)", "1600x1200 (4:3)", "1920x1440 (4:3)"
    };

    public static final int [] AVAILABLE_WIDTHS = {960, 1024, 1280, 1600, 1920, 800, 1152, 1400, 1600, 1920};
    public static final int [] AVAILABLE_HEIGHTS = {540, 576, 720, 900, 1080, 600, 864, 1050, 1200, 1440};

    // Viewport configuration.
    private static final int VIEWPORT_MULTIPLIER = 2;
    public static final int VIEWPORT_WIDTH = 16 * VIEWPORT_MULTIPLIER;
    public static final int VIEWPORT_HEIGHT = 9 * VIEWPORT_MULTIPLIER;

    // Physics configuration.
    public static final Vector2 PLATFORM_GRAVITY = new Vector2(0, -5.0f);
    public static final Vector2 TOPDOWN_GRAVITY = new Vector2(0f, 0f);
    public static final float LINEAR_DAMPING = 5.0f;
    public static final float ANGULAR_DAMPING = 0.05f;
    public static final float DENSITY = 10.0f;
    public static final float FRICTION = 0.5f;
    public static final float RESTITUTION = 0.0f;

    public static final float OBJECT_ACCELERATION = 2.0f;
    public static final float OBJECT_MAX_SPEED = 4.0f;

    // Collision class configuration.
    public static final short BIT_NOTHING = 0;
    public static final short BIT_UNIT_ANY = 3;
    public static final short BIT_UNIT_PLAYER = 1;
    public static final short BIT_UNIT_NPC = 2;
    public static final short BIT_OBSTACLE_ANY = 12;
    public static final short BIT_OBSTACLE_OBJECT = 4;
    public static final short BIT_OBSTACLE_TERRAIN = 8;

    // TMX layer configuration.
    public static final String MAP_LAYER_TERRAIN = "terrain";
    public static final String MAP_LAYER_BACKGROUND = "background";
    public static final String MAP_LAYER_FOLIAGE = "foliage";
    public static final String MAP_LAYER_OBJECT = "objects";

    // TMX attribute configuration.
    public static final String MAP_TILESET_MAIN = "default-tiles";
    public static final String MAP_PROPERTY_SPAWNPOINT = "spawn-point";
    public static final String MAP_PROPERTY_ANIMATION = "animation";
    public static final String MAP_PROPERTY_SPEED = "speed";
    public static final float MAP_DEFAULT_SPEED = 1.0f;

    // Development variables.
    public static final boolean DEBUG_MODE = true;
    public static final DebugRendering DEFAULT_DEBUG_RENDERING = DebugRendering.ALL;

    // UI values:
    public static final int SLIDER_MIN = 0;
    public static final int SLIDER_MAX = 100;
    public static final int SLIDER_STEP  = 10;

    // Default widget dimensions.
    public static final int UI_PERCENT_WIDTH = 40;
    public static final int UI_BUTTON_WIDTH = 270;
    public static final int UI_SMALL_BUTTON_WIDTH = 135;
    public static final int UI_MENU_ITEM_PADDING = 5;
    public static final int UI_SEPARATOR_SPACE = 20;
    public static final int UI_INDENT_TOP = 50;

    public static final int UI_DIALOG_WIDTH = 300;
    public static final int UI_DIALOG_HEIGHT = 200;

    public enum DebugRendering {
        DEBUG, GRAPHICS, ALL
    }

    public enum Huds {
        STANDARD, MAINMENU, GAMEMENU, HOTKEYSMENU, SETTINGSMENU,
        GRAPHICSMENU, AUDIOMENU, GAMEPLAYMENU, CREDITSMENU
    }

    public enum Screens {
        SPLASH, MENU, FOREST, OUTSKIRTS
    }

    public enum Input {
        GLOBAL, GAME, PLATFORM, TOPDOWN,
        FOREST, OUTSKIRTS
    }

    public enum Dialog {
        INVENTORY, CHARACTER, QUEST, EVENT
    }
}
