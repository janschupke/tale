package eu.janschupke.buddy.framework.base.event.global;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Message event for hint dialog toggle.
 */
public class ToggleDialogsEvent extends BaseEvent {
    public ToggleDialogsEvent(final App app) {
        super(app, app.getLang().get("event.global.toggle.dialogs"));
    }

    @Override
    public void trigger() {
        addEventMessage();
    }
}
