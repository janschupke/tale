package io.schupke.tale.base.event;

import io.schupke.tale.base.App;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.base.ui.dialog.InfoDialog;

/**
 * Base class for all game events.
 * Provides common functionality for event handling and processing.
 */
public abstract class BaseEvent {
    protected App app;
    protected boolean triggered;
    protected boolean repeatable;
    protected String eventMessage;

    /**
     * Indicates that this event will show dialog upon trigger.
     */
    protected boolean withDialog;

    public BaseEvent(final App app, String eventMessage) {
        this.app = app;
        this.eventMessage = eventMessage;
    }

    /**
     * Sets the event as triggered.
     * Specific logic is specified in subclasses.
     */
    public void trigger() {
        triggered = true;
    }

    /**
     * All logic for updating event messages (adding to the event log) associated to the event.
     */
    protected abstract void updateMessages();

    /**
     * All logic associated with quest handling during the event.
     */
    protected abstract void updateQuests();

    /**
     * Any other logic that might need to be coded for the event.
     */
    protected abstract void updateGameState();

    /**
     * All interaction adjustments that take place during the event.
     */
    protected abstract void updateInteractions();

    /**
     * Returns information about the triggerability of given event.
     *
     * @return True is the event is repeatable or has not been triggered yet. False otherwise.
     */
    public boolean canTrigger() {
        return (!triggered || repeatable);
    }

    /**
     * Handles the dialog display according to the current settings.
     *
     * @param dialog Dialog to be shown.
     */
    protected void showDialog(InfoDialog dialog) {
        showDialog(dialog, false);
    }

    /**
     * Handles dialog display, allows to force bypass the settings
     * flag that disables dialog display.
     * @param dialog Dialog to be shown.
     * @param force Forces dialog disable bypass if true.
     */
    protected void showDialog(InfoDialog dialog, boolean force) {
        if (app.getSettingsManager().getConfig().isEnableDialogs() || force) {
            dialog.show(app.getUi());
            ((GameScreen) app.getScreen()).getWorld().getPlayerUnit().stop();
        }
    }

    public String getEventMessage() {
        return eventMessage;
    }

    /**
     * Adds event message to the log and updates the view.
     * If no message is set, does nothing.
     */
    protected void addEventMessage() {
        if (eventMessage.isEmpty()) return;
        app.getGameState().getMessageLog().addEvent(this);
    }
}
