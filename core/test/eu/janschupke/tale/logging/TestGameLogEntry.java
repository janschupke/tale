package eu.janschupke.tale.logging;

import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import junit.framework.TestCase;

/**
 * Unit test for GameLogEntry functionality.
 * Tests individual log entry creation and management.
 */
public class TestGameLogEntry extends TestCase {
    public void testCreateEntry() {
        GameLogEntry gameLogEntry = new GameLogEntry(GameEventTags.GLOBAL_NEW_GAME, Screens.FOREST);
        assertEquals(gameLogEntry.getTag(), GameEventTags.GLOBAL_NEW_GAME);
        assertEquals(gameLogEntry.getLevel(), Screens.FOREST);
        assertTrue(gameLogEntry.getTimestamp() != null);
    }
}
