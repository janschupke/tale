package eu.janschupke.tale.base.container.message;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.container.DataContainer;
import eu.janschupke.tale.base.event.BaseEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Container of all occurred events' messages.
 *
 * @author jan.schupke@gmail.com
 */
public class MessageLog extends DataContainer {
    private List<MessageLogEntry> events;

    public MessageLog(final App app) {
        super(app);
        events = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (MessageLogEntry e : events) {
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
        MessageLogEntry entry = new MessageLogEntry(app, event.getEventMessage());
        events.add(entry);
        update();
    }
}
