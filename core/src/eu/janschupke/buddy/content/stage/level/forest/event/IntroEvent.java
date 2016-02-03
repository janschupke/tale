package eu.janschupke.buddy.content.stage.level.forest.event;

import com.badlogic.gdx.Gdx;
import eu.janschupke.buddy.content.stage.level.forest.dialog.IntroDialog;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;
import eu.janschupke.buddy.framework.util.Utility;

/**
 * An event that is triggered shortly after the game starts.
 */
public class IntroEvent extends BaseEvent {
    private IntroDialog introDialog;

    public IntroEvent(final App app) {
        super(app);
        repeatable = false;

        introDialog = new IntroDialog(app);
    }

    @Override
    public void trigger() {
        super.trigger();
        Gdx.app.debug("IntroEvent#trigger", "Triggering intro event.");

        Utility.getHud(app).getEventLogTable().addMessage(app.getLang().get("level.forest.event.intro.text"));
        introDialog.show(app.getUi());
    }
}
