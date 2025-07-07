package eu.janschupke.tale_analyzer.entity.measurement.data;

import eu.janschupke.tale_analyzer.entity.measurement.model.GameEvent;
import eu.janschupke.tale_analyzer.entity.measurement.model.GameEventModel;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * Model of the player's event summary page.
 *
 * @author jan.schupke@gmail.com
 */
public class EventSummary extends Observable implements Serializable {
    private Map<String, Integer> events;

    public EventSummary() {
        events = new HashMap<>();
    }

    public void reset() {
        events.clear();
        setChanged();
        notifyObservers();
    }

    public void load(EventSummary eventSummary) {
        events = eventSummary.getEvents();
        setChanged();
        notifyObservers();
    }

    /**
     * Creates new summary based on current data selection.
     *
     * @param model Loaded game event model.
     * @param playthrough Playthrough from the currently selected data set.
     */
    public void refresh(GameEventModel model, Playthrough playthrough) {
        events.clear();

        // Add every possible event.
        for (GameEvent gameEvent : model.getEvents()) {
            events.put(gameEvent.getTag(), 0);
        }

        // Increment counts based on playthrough data.
        for(PlaythroughEvent playthroughEvent : playthrough.getEvents()) {
            String tag = playthroughEvent.getTag();
            events.put(tag, events.get(tag) + 1);
        }

        setChanged();
        notifyObservers();
    }

    public Map<String, Integer> getEvents() {
        return events;
    }
}
