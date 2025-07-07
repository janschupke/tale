package eu.janschupke.tale_analyzer.entity.measurement.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Model of the player's playhrough.
 *
 * @author jan.schupke@gmail.com
 */
public class Playthrough extends Observable implements Serializable {
    private List<PlaythroughEvent> events;

    public Playthrough() {
        events = new ArrayList<>();
    }

    public List<PlaythroughEvent> getEvents() {
        return events;
    }
}
