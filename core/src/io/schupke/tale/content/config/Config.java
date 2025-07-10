package io.schupke.tale.content.config;

import com.badlogic.gdx.math.Vector2;

import io.schupke.tale.content.config.enumeration.Screens;

/**
 * Default configuration and global constants.
 */
public class Config {
    // Global untranslated strings.
    public static final String GAME_PREFIX = "tale";
    public static final String GAME_TITLE = "Tale of the Yellow Wanderer";
    public static final String PREFERENCES_SETTINGS = "settings";

    // Filesystem values.
    public static final String FILE_PATH = System.getProperty("user.home") +
            System.getProperty("file.separator") +
            ".schupke" +
            System.getProperty("file.separator") +
            "tale" +
            System.getProperty("file.separator");

    // Screen configuration.
    public static final boolean SCREEN_RESIZABLE = false;

    public static final String[] AVAILABLE_RESOLUTIONS = {
            "1024x576 (16:9)", "1280x720 (16:9)", "1600x900 (16:9)", "1920x1080 (16:9)",
            "1152x864 (4:3)", "1400x1050 (4:3)", "1600x1200 (4:3)", "1920x1440 (4:3)"
    };

    public static final int[] AVAILABLE_WIDTHS = {1024, 1280, 1600, 1920, 1152, 1400, 1600, 1920};
    public static final int[] AVAILABLE_HEIGHTS = {576, 720, 900, 1080, 864, 1050, 1200, 1440};

    public static final int NARROW_VIEW_THRESHOLD = Config.AVAILABLE_RESOLUTIONS.length / 2;

    // Entity configuration
    public static final Vector2 DEFAULT_UNIT_SIZE = new Vector2(0.8f, 0.8f);
    public static final Vector2 DEFAULT_ITEM_SIZE = new Vector2(0.4f, 0.4f);
    
    // Physics configuration.
    public static final Vector2 PLATFORM_GRAVITY = new Vector2(0, -5.0f);
    public static final Vector2 TOPDOWN_GRAVITY = new Vector2(0f, 0f);
    public static final float LINEAR_DAMPING = 8.0f;
    public static final float ANGULAR_DAMPING = 0.05f;
    public static final float DENSITY = 10.0f;
    public static final float FRICTION = 0.5f;
    public static final float RESTITUTION = 0.0f;
    public static final float OBJECT_ACCELERATION = 2.0f;
    public static final float OBJECT_MAX_SPEED = 2.8f;
    
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
    public static final String MAP_LAYER_OBJECT = "objects";
    
    // TMX attribute configuration.
    public static final String MAP_TILESET_MAIN = "default-tiles";
    public static final String MAP_PROPERTY_ANIMATION = "animation";
    public static final String MAP_PROPERTY_SPEED = "speed";
    public static final float MAP_DEFAULT_SPEED = 1.0f;
    
    // Development variables.
    public static final boolean DEBUG_MODE = false;
    public static final boolean DEBUG_OBJECT_POSITION = false;
    
    // UI values.
    public static final int SLIDER_MIN = 0;
    public static final int SLIDER_MAX = 100;
    public static final int SLIDER_STEP = 10;
    
    // Default widget dimensions.
    public static final int UI_INDENT_TITLE = 45;
    public static final int UI_PERCENT_WIDTH = 40;
    public static final int UI_BUTTON_WIDTH = 270;
    public static final int UI_SMALL_BUTTON_WIDTH = 135;
    public static final int UI_MENU_ITEM_PADDING = 5;
    public static final int UI_MENU_ITEM_PADDING_DIM = 2;
    public static final int UI_SEPARATOR_SPACE = 15;
    public static final int UI_INDENT_TOP = 60;
    public static final int HUD_INNER_PADDING = 10;
    public static final int HUD_BUTTON_PADDING = 5;
    public static final int HUD_BUTTON_PADDING_DIM = 3;
    public static final int HUD_LOG_BUTTON_WIDTH = 100;
    public static final int HUD_HINT_TOP_PADDING = 200;
    public static final int HUD_HINT_WIDTH = 220;
    public static final int HUD_INDICATOR_WIDTH = 220;
    public static final int HUD_TOP_BUTTON_WIDTH = 100;
    public static final int DIALOG_TOP_PADDING = 35;
    public static final int DIALOG_BOTTOM_PADDING = 10;
    public static final int DIALOG_SIDE_PADDING = 10;
    public static final int DIALOG_BUTTON_TOP_PADDING = 10;
    public static final int UI_DIALOG_WIDTH = 300;
    public static final int UI_DIALOG_HEIGHT = 200;
    
    // Gameplay configuration.
    public static final int INVENTORY_CAPACITY = 8;
    public static final Screens FIRST_LEVEL = Screens.FOREST;
    
    // Viewport configuration.
    private static final int VIEWPORT_WIDE_MULTIPLIER = 1;
    public static final int VIEWPORT_WIDE_WIDTH = 16 * VIEWPORT_WIDE_MULTIPLIER;
    public static final int VIEWPORT_WIDE_HEIGHT = 9 * VIEWPORT_WIDE_MULTIPLIER;
    private static final int VIEWPORT_MULTIPLIER = 3;
    public static final int VIEWPORT_WIDTH = 4 * VIEWPORT_MULTIPLIER;
    public static final int VIEWPORT_HEIGHT = 3 * VIEWPORT_MULTIPLIER;
}
