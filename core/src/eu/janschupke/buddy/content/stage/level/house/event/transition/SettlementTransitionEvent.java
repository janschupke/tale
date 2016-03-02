package eu.janschupke.buddy.content.stage.level.house.event.transition;

import eu.janschupke.buddy.content.config.enumeration.Huds;
import eu.janschupke.buddy.content.config.enumeration.Screens;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.TransitionEvent;
import eu.janschupke.buddy.framework.util.Utility;

/**
 * Transition event from House to Settlement.
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
