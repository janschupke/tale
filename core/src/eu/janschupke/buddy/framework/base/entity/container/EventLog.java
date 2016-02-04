package eu.janschupke.buddy.framework.base.entity.container;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Container of all occurred events.
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
        }

        return result.toString();
    }

    public void addEvent(BaseEvent event) {
        EventLogEntry entry = new EventLogEntry(app, event.getEventMessage());
        events.add(entry);
    }
}
