package eu.janschupke.tale.content.event;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.event.GeneralEvent;

/**
 * Message event for hint dialog toggle.
 *
 * @author jan.schupke@gmail.com
 */
public class ToggleDialogsEvent extends GeneralEvent {
    public ToggleDialogsEvent(final App app) {
        super(app, app.getLang().get("event.global.toggle.dialogs"));
        repeatable = true;
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
