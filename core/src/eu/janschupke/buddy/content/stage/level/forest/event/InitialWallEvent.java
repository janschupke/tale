package eu.janschupke.buddy.content.stage.level.forest.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;
import eu.janschupke.buddy.framework.base.ui.dialog.InfoDialog;

/**
 * An event triggered by trying to proceed to the next part of the world
 * before picking up the coin.
 * @author jan.schupke@gmail.com
 */
public class InitialWallEvent extends BaseEvent {
    /**
     * Introduction dialog.
     */
    class InitialWallDialog extends InfoDialog {
        public InitialWallDialog(final App app) {
            super(app, app.getLang().get("level.forest.dialog.wall.init.title"));
            label.setText(app.getLang().get("level.forest.event.wall.init.text"));
        }
    }

    private InitialWallDialog initialWallDialog;

    public InitialWallEvent(final App app) {
        super(app, app.getLang().get("level.forest.event.wall.init.text"));
        repeatable = true;
        initialWallDialog = new InitialWallDialog(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
        showDialog(initialWallDialog);
        addEventMessage();
    }
}
