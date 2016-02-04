package eu.janschupke.buddy.content.stage.level.forest.event;

import eu.janschupke.buddy.content.stage.level.forest.dialog.ItemHintDialog;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.MessageEvent;

/**
 * Item introduction event.
 */
public class ItemHintEvent extends MessageEvent {
    private ItemHintDialog itemHintDialog;

    public ItemHintEvent(final App app) {
        super(app, app.getLang().get("level.forest.event.item.text"));
        itemHintDialog = new ItemHintDialog(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
        itemHintDialog.show(app.getUi());
    }
}
