package eu.janschupke.tale.logging;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.logging.utility.GameLogParser;
import junit.framework.TestCase;

/**
 * Unit test for logging parser functionality.
 * Tests XML export and parsing capabilities.
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
