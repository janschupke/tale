package eu.janschupke.tale.logging;

import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;

import java.util.Calendar;

/**
 * One personality entry, consisting of a description
 * and a number of metrics.
 *
 * @author jan.schupke@gmail.com
 */
public class GameLogEntry {
    /**
     * Timestamp of the log entry occurrence.
     */
    private Long timestamp;

    /**
     * Game screen at which the entry was logged.
     */
    private Screens level;

    /**
     * Unique tag for the event
     */
    private GameEventTags tag;

    public GameLogEntry(final GameEventTags tag, final Screens level) {
        timestamp = Calendar.getInstance().getTimeInMillis();
        this.level = level;
        this.tag = tag;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public Screens getLevel() {
        return level;
    }

    public GameEventTags getTag() {
        return tag;
    }
}
