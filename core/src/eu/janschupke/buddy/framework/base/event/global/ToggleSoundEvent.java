package eu.janschupke.buddy.framework.base.event.global;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Message event for sound toggle.
 */
public class ToggleSoundEvent extends BaseEvent {
    public ToggleSoundEvent(final App app) {
        super(app, app.getLang().get("event.global.toggle.sound"));
    }

    @Override
    public void trigger() {
        addEventMessage();
    }
}
