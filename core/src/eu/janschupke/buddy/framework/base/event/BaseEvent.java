package eu.janschupke.buddy.framework.base.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.ui.dialog.InfoDialog;
import eu.janschupke.buddy.framework.util.Utility;

/**
 * Base class for all in-game events.
 */
public abstract class BaseEvent {
    protected App app;
    protected boolean triggered;
    protected boolean repeatable;
    protected String eventMessage;

    public BaseEvent(final App app) {
        this(app, "");
    }

    public BaseEvent(final App app, String eventMessage) {
        this.app = app;
        this.eventMessage = eventMessage;
    }

    public void trigger() {
        triggered = true;
        if (app.getSettingsManager().getConfig().isEnableDialogs()) {
            ((GameScreen)app.getScreen()).getWorld().getPlayerUnit().stop();
        }
    }

    public boolean canTrigger() {
        return (!triggered || repeatable);
    }

    /**
     * Handles the dialog display according to the current settings.
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
        app.getCharacter().getEventLog().addEvent(this);
        Utility.getHud(app).getEventLogTable().updateMessages(app.getCharacter().getEventLog().toString());
    }
}
