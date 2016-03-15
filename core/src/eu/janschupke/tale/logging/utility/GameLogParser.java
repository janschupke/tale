package eu.janschupke.tale.logging.utility;

import com.badlogic.gdx.Gdx;
import eu.janschupke.tale.content.config.Config;
import eu.janschupke.tale.logging.GameLog;
import eu.janschupke.tale.logging.GameLogEntry;

/**
 * Parser class that takes care of the personality model processing
 * and parsing into XML.
 *
 * @author jan.schupke@gmail.com
 */
public class GameLogParser {
    public static void parseToXml(final GameLog gameLog) {
        Gdx.app.debug("GameLogParser#parseToXml", "Dumping game log");

        if (Config.DEBUG_MODE) {
            for (GameLogEntry entry : gameLog.getEntries()) {
                System.out.println(entry.getTag());
            }
        }

        // TODO: xml parsing, saving to file
    }
}
