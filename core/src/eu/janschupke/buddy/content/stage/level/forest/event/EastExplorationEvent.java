package eu.janschupke.buddy.content.stage.level.forest.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;
import eu.janschupke.buddy.framework.base.ui.dialog.InfoDialog;

/**
 * Exploration event for the east optional area.
 *
 * @author jan.schupke@gmail.com
 */
public class EastExplorationEvent extends BaseEvent {
    private EastExplorationDialog eastExplorationDialog;

    public EastExplorationEvent(final App app) {
        super(app, app.getLang().get("level.forest.event.exploration.east.text"));
        eastExplorationDialog = new EastExplorationDialog(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
        showDialog(eastExplorationDialog);
        addEventMessage();
    }

    /**
     * Exploration dialog.
     */
    class EastExplorationDialog extends InfoDialog {
        public EastExplorationDialog(final App app) {
            super(app, app.getLang().get("level.forest.dialog.exploration.east.title"));
            label.setText(app.getLang().get("level.forest.event.exploration.east.text"));
        }
    }
}
