package eu.janschupke.tale.content.stage.level.forest.event.general;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.event.GeneralEvent;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.base.ui.dialog.InfoDialog;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;

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
        withDialog = true;
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
        app.getGameLog().addEntry(GameEventTags.FOREST_GENERAL_INTRO_CONTACT, ((BaseScreen)app.getScreen()).getTag());
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
