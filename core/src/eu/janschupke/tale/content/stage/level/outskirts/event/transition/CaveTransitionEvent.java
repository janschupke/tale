package eu.janschupke.tale.content.stage.level.outskirts.event.transition;

import eu.janschupke.tale.content.config.enumeration.Huds;
import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.base.event.TransitionEvent;
import eu.janschupke.tale.framework.util.Utility;

/**
 * Event for screen transition from Outskirts to Cave.
 *
 * @author jan.schupke@gmail.com
 */
public class CaveTransitionEvent extends TransitionEvent {
    public CaveTransitionEvent(final App app) {
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
        Utility.preservePlayerMovement(app, Screens.CAVE);
        Utility.transitionScreens(app, app.getScreenInstance(Screens.CAVE), app.getHud(Huds.STANDARD));
    }

    @Override
    protected void updateInteractions() {

    }
}
