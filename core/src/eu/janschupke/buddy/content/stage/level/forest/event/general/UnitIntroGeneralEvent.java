package eu.janschupke.buddy.content.stage.level.forest.event.general;

import eu.janschupke.buddy.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.GeneralEvent;
import eu.janschupke.buddy.framework.base.screen.BaseScreen;
import eu.janschupke.buddy.framework.base.ui.dialog.InfoDialog;

/**
 * Introductory event for unit interactions.
 *
 * @author jan.schupke@gmail.com
 */
public class UnitIntroGeneralEvent extends GeneralEvent {
    private UnitIntroDialog unitIntroDialog;

    public UnitIntroGeneralEvent(final App app) {
        super(app, app.getLang().get("level.forest.event.unit-intro.text"));
        unitIntroDialog = new UnitIntroDialog(app);
    }

    @Override
    protected void updateMessages() {
        showDialog(unitIntroDialog);
        addEventMessage();
    }

    @Override
    protected void updateQuests() {

    }

    @Override
    protected void updateGameState() {
        app.getGameLog().addEntry(GameEventTags.FOREST_UNIT_INTRO_CONTACT, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }

    /**
     * Unit introduction dialog.
     */
    class UnitIntroDialog extends InfoDialog {
        public UnitIntroDialog(final App app) {
            super(app, app.getLang().get("level.forest.dialog.unit-intro.title"));
            label.setText(app.getLang().get("level.forest.event.unit-intro.text"));
        }
    }
}
