package eu.janschupke.buddy.content.stage.level.forest.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;
import eu.janschupke.buddy.framework.base.ui.dialog.InfoDialog;

/**
 * Exploration event for the south optional area.
 *
 * @author jan.schupke@gmail.com
 */
public class SouthExplorationEvent extends BaseEvent {
    private SouthExplorationDialog southExplorationDialog;

    public SouthExplorationEvent(final App app) {
        super(app, app.getLang().get("level.forest.event.exploration.south.text"));
        southExplorationDialog = new SouthExplorationDialog(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
        showDialog(southExplorationDialog);
        addEventMessage();
    }

    /**
     * Exploration dialog.
     */
    class SouthExplorationDialog extends InfoDialog {
        public SouthExplorationDialog(final App app) {
            super(app, app.getLang().get("level.forest.dialog.exploration.south.title"));
            label.setText(app.getLang().get("level.forest.event.exploration.south.text"));
        }
    }
}
