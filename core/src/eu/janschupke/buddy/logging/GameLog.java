package eu.janschupke.buddy.logging;

import java.util.ArrayList;
import java.util.List;

/**
 * Main personality model, consisting of a list of entries,
 * each of which influences a number of personality traits by a configured values.
 *
 * @author jan.schupke@gmail.com
 */
public class GameLog {
    private List<GameLogEntry> entries;

    public GameLog() {
        entries = new ArrayList<>();
    }

    public void addEntry(GameLogEntry entry) {
        entries.add(entry);
    }

    public void addEntry(String description) {
        entries.add(new GameLogEntry(description));
    }

    public List<GameLogEntry> getEntries() {
        return entries;
    }

    public void clear() {
        entries.clear();
    }
}
