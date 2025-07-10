package io.schupke.tale.base.container.message;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.DataContainer;

/**
 * Represents a single entry in the message log.
 * Contains message data and metadata.
 */
public class MessageLogEntry extends DataContainer {
    private String eventMessage;

    public MessageLogEntry(final App app, String eventMessage) {
        super(app);
        this.eventMessage = eventMessage;
    }

    @Override
    public String toString() {
        return eventMessage;
    }
}
