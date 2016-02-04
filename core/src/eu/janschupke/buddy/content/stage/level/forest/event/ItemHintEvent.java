package eu.janschupke.buddy.content.stage.level.forest.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;
import eu.janschupke.buddy.framework.base.ui.dialog.InfoDialog;
import eu.janschupke.buddy.framework.config.Config;
import eu.janschupke.buddy.framework.util.Utility;

/**
 * Item introduction event.
 */
public class ItemHintEvent extends BaseEvent {
    /**
     * Item introduction dialog.
     */
    private class ItemHintDialog extends InfoDialog {
        public ItemHintDialog(final App app) {
            super(app, app.getLang().get("level.forest.dialog.item.title"));
            // TODO: set text utility
            label.setText(Utility.optimizeNewLines(app.getLang().get("level.forest.event.item.text"), Config.DIALOG_TEXT_WIDTH));
        }
    }

    private ItemHintDialog itemHintDialog;

    public ItemHintEvent(final App app) {
        super(app, app.getLang().get("level.forest.event.item.text"));
        itemHintDialog = new ItemHintDialog(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
        showDialog(itemHintDialog);
        addEventMessage();
    }
}
