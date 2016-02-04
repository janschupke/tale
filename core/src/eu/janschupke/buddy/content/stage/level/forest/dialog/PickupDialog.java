package eu.janschupke.buddy.content.stage.level.forest.dialog;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.dialog.InfoDialog;

/**
 * Shows after player's firt item pickup.
 * Contains additional intro text.
 */
public class PickupDialog extends InfoDialog {
    public PickupDialog(final App app) {
        super(app, app.getLang().get("level.forest.dialog.pickup.title"));
        label.setText(app.getLang().get("level.forest.event.pickup.text"));
    }
}
