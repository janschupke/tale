package eu.janschupke.tale_analyzer.entity.measurement.data;

import java.io.Serializable;
import java.util.Observable;

/**
 * Game event containing playthrough-specific data.
 *
 * @author jan.schupke@gmail.com
 */
public class PlaythroughEvent extends Observable implements Serializable {
    private long timestamp;
    private String level;
    private String tag;

    public PlaythroughEvent(long timestamp, String level, String tag) {
        this.timestamp = timestamp;
        this.level = level;
        this.tag = tag;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getLevel() {
        return level;
    }

    public String getTag() {
        return tag;
    }
}
