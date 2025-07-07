package eu.janschupke.tale.content.stage.level.forest.event.general;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.event.GeneralEvent;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.base.ui.dialog.InfoDialog;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Introductory event for unit interactions.
 *
 * @author jan.schupke@gmail.com
 */
public class UnitIntroGeneralEvent extends GeneralEvent {
    /**
     * Unit introduction dialog.
     */
    class UnitIntroDialog extends InfoDialog {
        public UnitIntroDialog(final App app) {
            super(app, app.getLang().get("level.forest.dialog.unit-intro.title"));
            label.setText(app.getLang().get("level.forest.event.unit-intro.text"));
        }
    }

    private UnitIntroDialog unitIntroDialog;

    public UnitIntroGeneralEvent(final App app) {
        super(app, app.getLang().get("level.forest.event.unit-intro.text"));
        unitIntroDialog = new UnitIntroDialog(app);
//        withDialog = true;
    }

    @Override
    protected void updateMessages() {
//        showDialog(unitIntroDialog);
//        addEventMessage();
    }

    @Override
    protected void updateQuests() {

    }

    @Override
    protected void updateGameState() {
        app.getGameLog().addEntry(GameEventTags.FOREST_GENERAL_UNIT_INTRO_CONTACT, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
