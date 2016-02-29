package eu.janschupke.buddy.content.stage.level.forest.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.GeneralEvent;
import eu.janschupke.buddy.framework.base.ui.dialog.InfoDialog;

/**
 * Item introduction event.
 *
 * @author jan.schupke@gmail.com
 */
public class ItemIntroGeneralEvent extends GeneralEvent {
    private ItemHintDialog itemHintDialog;

    public ItemIntroGeneralEvent(final App app) {
        super(app, app.getLang().get("level.forest.event.item.text"));
        itemHintDialog = new ItemHintDialog(app);
    }

    @Override
    protected void updateMessages() {
        showDialog(itemHintDialog);
        addEventMessage();
    }

    @Override
    protected void updateQuests() {

    }

    @Override
    protected void updateGameState() {

    }

    @Override
    protected void updateInteractions() {

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
