package eu.janschupke.buddy.framework.base.event.global;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.MessageEvent;

/**
 * Created by uzivatel on 04/02/2016.
 */
public class ToggleMusicEvent extends MessageEvent {
    public ToggleMusicEvent(final App app) {
        super(app, app.getLang().get("event.global.toggle.music"));
    }
}
