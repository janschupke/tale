package eu.janschupke.tale.content.event;

import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.base.event.GeneralEvent;

/**
 * Message event for hint dialog toggle.
 *
 * @author jan.schupke@gmail.com
 */
public class ToggleDialogsEvent extends GeneralEvent {
    public ToggleDialogsEvent(final App app) {
        super(app, app.getLang().get("event.global.toggle.dialogs"));
    }

    @Override
    protected void updateMessages() {
        addEventMessage();
    }

    @Override
    protected void updateQuests() {

    }

    @Override
    protected void updateGameState() {
        boolean current = app.getSettingsManager().getConfig().isEnableDialogs();
        app.getSettingsManager().getConfig().setEnableDialogs(!current);
    }

    @Override
    protected void updateInteractions() {

    }
}
