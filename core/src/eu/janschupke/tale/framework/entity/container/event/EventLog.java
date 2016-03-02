package eu.janschupke.tale.framework.entity.container.event;

import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.container.DataContainer;
import eu.janschupke.tale.framework.event.BaseEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Container of all occurred events' messages.
 *
 * @author jan.schupke@gmail.com
 */
public class EventLog extends DataContainer {
    private List<EventLogEntry> events;

    public EventLog(final App app) {
        super(app);
        events = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (EventLogEntry e : events) {
            result.append(e.toString());
            result.append(System.getProperty("line.separator"));
            result.append(System.getProperty("line.separator"));
        }

        return result.toString();
    }

    /**
     * Adds description of the provided event into the log.
     *
     * @param event Provided event.
     */
    public void addEvent(BaseEvent event) {
        EventLogEntry entry = new EventLogEntry(app, event.getEventMessage());
        events.add(entry);
        setChanged();
        notifyObservers();
    }
}
