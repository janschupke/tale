package eu.janschupke.buddy.framework.base.event.global;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Message event for music toggle.
 */
public class ToggleMusicEvent extends BaseEvent {
    public ToggleMusicEvent(final App app) {
        super(app, app.getLang().get("event.global.toggle.music"));
    }

    @Override
    public void trigger() {
        addEventMessage();
    }
}
