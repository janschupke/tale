package eu.janschupke.buddy.logging.tools;

import com.badlogic.gdx.Gdx;
import eu.janschupke.buddy.logging.GameLog;
import eu.janschupke.buddy.logging.GameLogEntry;

/**
 * Parser class that takes care of the personality model processing
 * and parsing into XML.
 *
 * @author jan.schupke@gmail.com
 */
public class GameLogParser {
    public static void parseToXml(final GameLog gameLog) {
        Gdx.app.debug("GameLogParser#parseToXml", "Dumping game log");

        // TODO
        for (GameLogEntry entry : gameLog.getEntries()) {
            System.out.println(entry.getTag());
        }
    }
}
