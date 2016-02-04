package eu.janschupke.buddy.content.stage.level.forest.dialog;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.dialog.InfoDialog;
import eu.janschupke.buddy.framework.config.Config;
import eu.janschupke.buddy.framework.util.Utility;

/**
 * Item introduction dialog.
 */
public class ItemHintDialog extends InfoDialog {
    public ItemHintDialog(final App app) {
        super(app, app.getLang().get("level.forest.dialog.item.title"));
        // TODO: set text utility
        label.setText(Utility.optimizeNewLines(app.getLang().get("level.forest.event.item.text"), Config.DIALOG_TEXT_WIDTH));
    }
}
