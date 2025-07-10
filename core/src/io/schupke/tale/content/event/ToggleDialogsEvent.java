package io.schupke.tale.content.event;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.GeneralEvent;

/**
 * Event for toggling dialog visibility.
 * Controls the display of dialog boxes and UI elements.
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
