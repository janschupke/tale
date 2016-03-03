package eu.janschupke.tale.framework.container.message;

import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.DataContainer;

/**
 * Entry of each event message that has occurred.
 *
 * @author jan.schupke@gmail.com
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
