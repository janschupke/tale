package eu.janschupke.buddy.content.stage.level.forest.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;
import eu.janschupke.buddy.framework.base.ui.dialog.InfoDialog;

/**
 * Wall event triggered when engaging contact with quest wall
 * before completing the initial quest.
 *
 * @author jan.schupke@gmail.com
 */
public class QuestWallEvent extends BaseEvent {
    private QuestWallDialog questWallDialog;

    public QuestWallEvent(final App app) {
        super(app, app.getLang().get("level.forest.event.wall.quest.text"));
        repeatable = true;
        questWallDialog = new QuestWallDialog(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
        showDialog(questWallDialog);
        addEventMessage();
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
