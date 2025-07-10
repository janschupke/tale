package io.schupke.tale.logging;

import java.util.ArrayList;
import java.util.List;

import io.schupke.tale.content.config.enumeration.Screens;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Main log model, consisting of a list of entries,
 * each of which influences a number of personality traits.
 * Exported log will be used for personality analysis.
 */
public class GameLog {
    private List<GameLogEntry> entries;

    public GameLog() {
        entries = new ArrayList<>();
    }

    /**
     * Adds game log entry.
     * @param eventTag Event identifier.
     * @param screenTag Current screen identifier.
     */
    public void addEntry(GameEventTags eventTag, Screens screenTag) {
        GameLogEntry entry = new GameLogEntry(eventTag, screenTag);
        entries.add(entry);
    }

    public List<GameLogEntry> getEntries() {
        return entries;
    }

    public void clear() {
        entries.clear();
    }
}
