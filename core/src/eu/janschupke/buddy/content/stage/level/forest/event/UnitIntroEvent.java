package eu.janschupke.buddy.content.stage.level.forest.event;

import com.badlogic.gdx.Gdx;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;
import eu.janschupke.buddy.framework.base.ui.dialog.InfoDialog;

/**
 * Introductory event for unit interactions.
 *
 * @author jan.schupke@gmail.com
 */
public class UnitIntroEvent extends BaseEvent {
    private UnitIntroDialog unitIntroDialog;

    public UnitIntroEvent(final App app) {
        super(app, app.getLang().get("level.forest.event.unit-intro.text"));
        unitIntroDialog = new UnitIntroDialog(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
        Gdx.app.debug("UnitIntroEvent#trigger", "Triggering unit intro event");
        showDialog(unitIntroDialog);
        addEventMessage();
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
