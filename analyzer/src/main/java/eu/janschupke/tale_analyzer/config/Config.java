package eu.janschupke.tale_analyzer.config;

/**
 * Global configuration.
 *
 * @author jan.schupke@gmail.com
 */
public class Config {
    public static final String APP_NAME = "Tale Game Log Analyzer";
    public static final int WINDOW_WIDTH = 1400;
    public static final int WINDOW_HEIGHT = 800;

    public static final int WINDOW_MIN_WIDTH = 800;
    public static final int WINDOW_MIN_HEIGHT = 600;

    public static final String FILE_PATH = System.getProperty("user.home") +
            System.getProperty("file.separator") +
            "schupke" +
            System.getProperty("file.separator") +
            "tale-analyzer" +
            System.getProperty("file.separator");
    public static final String FILE_MODEL = "model.obj";

    public static final String FILE_DATA_BFI = "bfi.csv";
    public static final String FILE_DATA_LOG = "log.xml";

    public static final String EXPORT_FULL_FILENAME = "result-full.xml";
    public static final String EXPORT_GROUPED_FILENAME = "result-groups.xml";

    // Game event model.
    public static final String ELEMENT_GAME_EVENT = "event";
    public static final String ELEMENT_GAME_TAG = "tag";
    public static final String ELEMENT_GAME_DESCRIPTION = "description";

    // Playthrough.
    public static final String ELEMENT_PLAYTHROUGH_EVENT = "event";
    public static final String ELEMENT_PLAYTHROUGH_TAG = "tag";
    public static final String ELEMENT_PLAYTHROUGH_TIME = "time";
    public static final String ELEMENT_PLAYTHROUGH_LEVEL = "level";

    // BFI model.
    public static final String ELEMENT_BFI_QUESTION = "question";
    public static final String ELEMENT_BFI_NUMBER = "number";
    public static final String ELEMENT_BFI_DESCRIPTION = "description";
    public static final String ELEMENT_BFI_TRAIT = "trait";
    public static final String ELEMENT_BFI_REVERSE = "reverse";

    public static final boolean DEBUG_MODE = true;
}
