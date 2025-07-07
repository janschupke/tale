package eu.janschupke.tale_analyzer.entity.measurement.model;

import java.io.Serializable;
import java.util.Observable;

/**
 * A single event withing the game.
 *
 * @author jan.schupke@gmail.com
 */
public class GameEvent extends Observable implements Serializable {
    private String tag;
    private String description;

    public GameEvent(String tag, String description) {
        this.tag = tag;
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public String getDescription() {
        return description;
    }
}
