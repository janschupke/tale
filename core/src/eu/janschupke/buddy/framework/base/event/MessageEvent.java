package eu.janschupke.buddy.framework.base.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.util.Utility;

/**
 * An event type that shows a visible message. Can also do other things.
 */
public class MessageEvent extends BaseEvent {
    protected String eventMessage;
    public MessageEvent(App app, String eventMessage) {
        super(app);
        this.eventMessage = eventMessage;
        repeatable = true;
    }

    public String getEventMessage() {
        return eventMessage;
    }

    @Override
    public void trigger() {
        super.trigger();
        app.getCharacter().getEventLog().addEvent(this);
        Utility.getHud(app).getEventLogTable().updateMessages(app.getCharacter().getEventLog().toString());
    }
}
