package eu.janschupke.tale.content.stage.level.forest.event.general;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.event.GeneralEvent;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.base.ui.dialog.InfoDialog;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;

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
        withDialog = true;
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
        app.getGameLog().addEntry(GameEventTags.FOREST_GENERAL_ITEM_INTRO_CONTACT, ((BaseScreen)app.getScreen()).getTag());
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
