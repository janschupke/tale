package eu.janschupke.buddy.content.stage.level.forest.event;

import eu.janschupke.buddy.content.stage.level.forest.dialog.ItemHintDialog;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;
import eu.janschupke.buddy.framework.util.Utility;

/**
 * Item introduction event.
 */
public class ItemHintEvent extends BaseEvent {
    private ItemHintDialog itemHintDialog;

    public ItemHintEvent(final App app) {
        super(app);
        repeatable = false;

        itemHintDialog = new ItemHintDialog(app);
    }

    @Override
    public void trigger() {
        super.trigger();
        Utility.getHud(app).getEventLogTable().addMessage(app.getLang().get("level.forest.event.item.text"));
        itemHintDialog.show(app.getUi());
    }
}
