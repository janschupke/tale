package eu.janschupke.buddy.content.stage.level.forest.event.general;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.GeneralEvent;
import eu.janschupke.buddy.framework.base.ui.dialog.InfoDialog;

/**
 * Wall event triggered when engaging contact with quest wall
 * before completing the initial quest.
 *
 * @author jan.schupke@gmail.com
 */
public class QuestWallGeneralEvent extends GeneralEvent {
    private QuestWallDialog questWallDialog;

    public QuestWallGeneralEvent(final App app) {
        super(app, app.getLang().get("level.forest.event.wall.quest.text"));
        repeatable = true;
        questWallDialog = new QuestWallDialog(app);
    }

    @Override
    protected void updateMessages() {

    }

    @Override
    protected void updateQuests() {

    }

    @Override
    protected void updateGameState() {
        showDialog(questWallDialog);
        addEventMessage();
    }

    @Override
    protected void updateInteractions() {

    }

    /**
     * Quest blocking message dialog.
     */
    class QuestWallDialog extends InfoDialog {
        public QuestWallDialog(final App app) {
            super(app, app.getLang().get("level.forest.dialog.wall.quest.title"));
            label.setText(app.getLang().get("level.forest.event.wall.quest.text"));
        }
    }
}
