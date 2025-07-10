package io.schupke.tale.logging;

import java.util.Calendar;

import io.schupke.tale.content.config.enumeration.Screens;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * One personality entry, consisting of a description
 * and a number of metrics.
 */
public class GameLogEntry {
    private Long timestamp;
    private Screens level;
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
