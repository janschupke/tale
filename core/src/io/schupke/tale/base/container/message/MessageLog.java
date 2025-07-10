package io.schupke.tale.base.container.message;

import java.util.ArrayList;
import java.util.List;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.DataContainer;
import io.schupke.tale.base.event.BaseEvent;

/**
 * Manages the game's message log system.
 * Tracks and displays game messages and notifications.
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
