package eu.janschupke.buddy.content.stage.level.forest.dialog;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.dialog.InfoDialog;

/**
 * Item introduction dialog.
 */
public class ItemHintDialog extends InfoDialog {
    public ItemHintDialog(final App app) {
        super(app, app.getLang().get("level.forest.dialog.item.title"));

        label.setText(app.getLang().get("level.forest.event.item.text"));
    }
}
