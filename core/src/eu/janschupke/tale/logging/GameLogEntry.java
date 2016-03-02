package eu.janschupke.tale.logging;

import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;

import java.util.Calendar;
import java.util.Date;

/**
 * One personality entry, consisting of a description
 * and a number of metrics.
 *
 * @author jan.schupke@gmail.com
 */
public class GameLogEntry {
    /**
     * Date of the log entry occurrence.
     */
    private Date date;

    /**
     * Game screen at which the entry was logged.
     */
    private Screens level;

    /**
     * Unique tag for the event
     */
    private GameEventTags tag;

    public GameLogEntry(final GameEventTags tag, final Screens level) {
        date = Calendar.getInstance().getTime();
        this.level = level;
        this.tag = tag;
    }

    public Date getDate() {
        return date;
    }

    public Screens getLevel() {
        return level;
    }

    public GameEventTags getTag() {
        return tag;
    }
}
