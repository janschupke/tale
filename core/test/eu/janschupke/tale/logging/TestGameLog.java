package eu.janschupke.tale.logging;

import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import junit.framework.TestCase;

/**
 * Unit test for GameLog functionality.
 * Tests the game logging system and entry management.
 */
public class TestGameLog extends TestCase {
    public void testAddEntry() {
        GameLog gameLog = new GameLog();
        assertEquals(0, gameLog.getEntries().size());
        gameLog.addEntry(GameEventTags.GLOBAL_NEW_GAME, Screens.MENU);
        assertEquals(1, gameLog.getEntries().size());
        gameLog.addEntry(GameEventTags.GLOBAL_NEW_GAME, Screens.MENU);
        assertEquals(2, gameLog.getEntries().size());
    }

    public void testGetEntries() {
        GameLog gameLog = new GameLog();
        gameLog.addEntry(GameEventTags.GLOBAL_NEW_GAME, Screens.MENU);
        assertTrue(gameLog.getEntries() != null);
    }

    public void testClear() {
        GameLog gameLog = new GameLog();
        gameLog.addEntry(GameEventTags.GLOBAL_NEW_GAME, Screens.MENU);
        gameLog.clear();
        assertEquals(0, gameLog.getEntries().size());
    }
}
