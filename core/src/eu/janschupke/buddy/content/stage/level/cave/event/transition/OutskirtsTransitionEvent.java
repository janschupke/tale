package eu.janschupke.buddy.content.stage.level.cave.event.transition;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.TransitionEvent;
import eu.janschupke.buddy.framework.config.enumeration.Huds;
import eu.janschupke.buddy.framework.config.enumeration.Screens;
import eu.janschupke.buddy.framework.util.Utility;

/**
 * Event for the transition from Cave to Outskirts.
 *
 * @author jan.schupke@gmail.com
 */
public class OutskirtsTransitionEvent extends TransitionEvent {
    public OutskirtsTransitionEvent(final App app) {
        super(app);
        repeatable = true;
    }

    @Override
    protected void updateMessages() {

    }

    @Override
    protected void updateQuests() {

    }

    @Override
    protected void updateGameState() {
        Utility.preservePlayerMovement(app, Screens.OUTSKIRTS);
        Utility.transitionScreens(app, app.getScreenInstance(Screens.OUTSKIRTS), app.getHud(Huds.STANDARD));
    }

    @Override
    protected void updateInteractions() {

    }
}