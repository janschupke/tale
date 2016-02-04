package eu.janschupke.buddy.content.stage.level.forest.event;

import com.badlogic.gdx.Gdx;
import eu.janschupke.buddy.content.stage.level.forest.dialog.IntroDialog;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.MessageEvent;

/**
 * An event that is triggered shortly after the game starts.
 */
public class IntroEvent extends MessageEvent {
    private IntroDialog introDialog;

    public IntroEvent(final App app) {
        super(app, app.getLang().get("level.forest.event.intro.text"));
        introDialog = new IntroDialog(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
        Gdx.app.debug("IntroEvent#trigger", "Triggering intro event.");

        introDialog.show(app.getUi());
    }
}
