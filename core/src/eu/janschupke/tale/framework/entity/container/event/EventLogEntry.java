package eu.janschupke.tale.framework.entity.container.event;

import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.container.DataContainer;

/**
 * Entry of each event that has occurred.
 *
 * @author jan.schupke@gmail.com
 */
public class EventLogEntry extends DataContainer {
    private String eventMessage;

    public EventLogEntry(final App app, String eventMessage) {
        super(app);
        this.eventMessage = eventMessage;
    }

    @Override
    public String toString() {
        return eventMessage;
    }
}
