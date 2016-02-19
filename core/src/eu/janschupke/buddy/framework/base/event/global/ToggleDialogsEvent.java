package eu.janschupke.buddy.framework.base.event.global;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;

/**
 * Message event for hint dialog toggle.
 * @author jan.schupke@gmail.com
 */
public class ToggleDialogsEvent extends BaseEvent {
    public ToggleDialogsEvent(final App app) {
        super(app, app.getLang().get("event.global.toggle.dialogs"));
    }

    /**
     * Toggles event dialog showing and updates the configuration.
     */
    @Override
    public void trigger() {
        boolean current = app.getSettingsManager().getConfig().isEnableDialogs();
        app.getSettingsManager().getConfig().setEnableDialogs(!current);
        addEventMessage();
    }
}
