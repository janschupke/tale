package eu.janschupke.buddy.content.stage.level.forest.event;

import com.badlogic.gdx.Gdx;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;
import eu.janschupke.buddy.framework.base.ui.dialog.InfoDialog;

/**
 * An event that is triggered shortly after the game starts.
 */
public class IntroEvent extends BaseEvent {
    /**
     * Introduction dialog.
     */
    class IntroDialog extends InfoDialog {
        public IntroDialog(final App app) {
            super(app, app.getLang().get("level.forest.dialog.intro.title"));
            label.setText(app.getLang().get("level.forest.event.intro.text"));
        }
    }

    private IntroDialog introDialog;

    public IntroEvent(final App app) {
        super(app, app.getLang().get("level.forest.event.intro.text"));
        introDialog = new IntroDialog(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
        Gdx.app.debug("IntroEvent#trigger", "Triggering intro event");
        showDialog(introDialog);
        addEventMessage();
    }
}
