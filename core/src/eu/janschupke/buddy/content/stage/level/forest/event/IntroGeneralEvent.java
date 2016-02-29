package eu.janschupke.buddy.content.stage.level.forest.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.GeneralEvent;
import eu.janschupke.buddy.framework.base.ui.dialog.InfoDialog;

/**
 * An event that is triggered shortly after the game starts.
 *
 * @author jan.schupke@gmail.com
 */
public class IntroGeneralEvent extends GeneralEvent {
    private IntroDialog introDialog;

    public IntroGeneralEvent(final App app) {
        super(app, app.getLang().get("level.forest.event.intro.text"));
        introDialog = new IntroDialog(app);
    }

    @Override
    protected void updateMessages() {
        showDialog(introDialog);
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
     * Introduction dialog.
     */
    class IntroDialog extends InfoDialog {
        public IntroDialog(final App app) {
            super(app, app.getLang().get("level.forest.dialog.intro.title"));
            label.setText(app.getLang().get("level.forest.event.intro.text"));
        }
    }
}