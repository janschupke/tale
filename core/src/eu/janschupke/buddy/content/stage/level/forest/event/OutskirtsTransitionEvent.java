package eu.janschupke.buddy.content.stage.level.forest.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;
import eu.janschupke.buddy.framework.config.Config;
import eu.janschupke.buddy.framework.util.Utility;

/**
 * Event for screen transition from Forest to Outskirts.
 *
 * @author jan.schupke@gmail.com
 */
public class OutskirtsTransitionEvent extends BaseEvent {
    public OutskirtsTransitionEvent(final App app) {
        super(app, "");
        repeatable = true;
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
        Utility.transitionScreens(app, app.getScreenInstance(Config.Screens.OUTSKIRTS), app.getHud(Config.Huds.STANDARD));
    }
}
