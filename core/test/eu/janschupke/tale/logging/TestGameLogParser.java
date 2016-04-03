package eu.janschupke.tale.logging;

import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.logging.utility.GameLogParser;
import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * Unit test for logging parser functionality.
 *
 * @author jan.schupke@gmail.com
 */
public class TestGameLogParser extends TestCase {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    public void testExportEventModel() {
        GameLogParser.exportEventModel();
    }

    public void testParseToXml() {
        GameLog gameLog = new GameLog();
        gameLog.addEntry(GameEventTags.GLOBAL_NEW_GAME, Screens.MENU);
        GameLogParser.parseToXml(gameLog);
    }
}
