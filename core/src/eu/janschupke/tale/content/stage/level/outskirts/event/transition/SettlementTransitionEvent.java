package eu.janschupke.tale.content.stage.level.outskirts.event.transition;

import eu.janschupke.tale.content.config.enumeration.Huds;
import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.TransitionEvent;
import eu.janschupke.tale.framework.utility.Utility;

/**
 * Event for transition from Outskirts to Settlement.
 *
 * @author jan.schupke@gmail.com
 */
public class SettlementTransitionEvent extends TransitionEvent {
    public SettlementTransitionEvent(final App app) {
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
        Utility.preservePlayerMovement(app, Screens.SETTLEMENT);
        Utility.transitionScreens(app, app.getScreenInstance(Screens.SETTLEMENT), app.getHud(Huds.STANDARD));
    }

    @Override
    protected void updateInteractions() {

    }
}
