package eu.janschupke.tale.content.stage.level.cave.event.transition;

import eu.janschupke.tale.content.config.enumeration.Huds;
import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.base.event.TransitionEvent;
import eu.janschupke.tale.framework.util.Utility;

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
