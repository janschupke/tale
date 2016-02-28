package eu.janschupke.buddy.content.stage.level.forest.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;
import eu.janschupke.buddy.framework.base.ui.dialog.InfoDialog;

/**
 * Exploration event for the north optional area.
 *
 * @author jan.schupke@gmail.com
 */
public class NorthExplorationEvent extends BaseEvent {
    private NorthExplorationDialog northExplorationDialog;

    public NorthExplorationEvent(final App app) {
        super(app, app.getLang().get("level.forest.event.exploration.north.text"));
        northExplorationDialog = new NorthExplorationDialog(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
        showDialog(northExplorationDialog);
        addEventMessage();
    }

    /**
     * Exploration dialog.
     */
    class NorthExplorationDialog extends InfoDialog {
        public NorthExplorationDialog(final App app) {
            super(app, app.getLang().get("level.forest.dialog.exploration.north.title"));
            label.setText(app.getLang().get("level.forest.event.exploration.north.text"));
        }
    }
}
