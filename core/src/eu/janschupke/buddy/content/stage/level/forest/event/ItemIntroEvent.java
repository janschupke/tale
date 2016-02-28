package eu.janschupke.buddy.content.stage.level.forest.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;
import eu.janschupke.buddy.framework.base.ui.dialog.InfoDialog;

/**
 * Item introduction event.
 *
 * @author jan.schupke@gmail.com
 */
public class ItemIntroEvent extends BaseEvent {
    private ItemHintDialog itemHintDialog;

    public ItemIntroEvent(final App app) {
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

    /**
     * Item introduction dialog.
     */
    private class ItemHintDialog extends InfoDialog {
        public ItemHintDialog(final App app) {
            super(app, app.getLang().get("level.forest.dialog.item.title"));
            label.setText(app.getLang().get("level.forest.event.item.text"));
        }
    }
}
