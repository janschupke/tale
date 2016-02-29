package eu.janschupke.buddy.framework.base.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.ui.dialog.InfoDialog;

/**
 * Base class for all in-game events.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class BaseEvent {
    protected App app;
    protected boolean triggered;
    protected boolean repeatable;
    protected String eventMessage;

    public BaseEvent(final App app, String eventMessage) {
        this.app = app;
        this.eventMessage = eventMessage;
    }

    /**
     * Sets the event as triggered and stops player movement.
     * Specific logic is specified in subclasses.
     */
    public void trigger() {
        triggered = true;
        if (app.getSettingsManager().getConfig().isEnableDialogs()) {
            ((GameScreen) app.getScreen()).getWorld().getPlayerUnit().stop();
        }
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
        if (app.getSettingsManager().getConfig().isEnableDialogs()) {
            dialog.show(app.getUi());
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
        app.getGameState().getEventLog().addEvent(this);
    }
}
