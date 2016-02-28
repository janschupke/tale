package eu.janschupke.buddy.content.stage.level.outskirts.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;
import eu.janschupke.buddy.framework.config.Config;
import eu.janschupke.buddy.framework.config.enumeration.Huds;
import eu.janschupke.buddy.framework.config.enumeration.Screens;
import eu.janschupke.buddy.framework.util.Utility;

/**
 * Event for the transition from Outskirts to Forest.
 *
 * @author jan.schupke@gmail.com
 */
public class ForestTransitionEvent extends BaseEvent {
    public ForestTransitionEvent(final App app) {
        super(app);
        repeatable = true;
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
        // TODO: refactor
        app.getGameState().getCurrentLevel().getWorld().getPlayerUnit().moveUp();
        app.getGameState().getCurrentLevel().getWorld().getPlayerUnit().stop();
        app.getGameState().getCurrentLevel().getWorld().getPlayerUnit().getBody()
                .setLinearVelocity(0, Config.PLAYER_SCREEN_TRANSITION_VELOCITY);

        Utility.transitionScreens(app, app.getScreenInstance(Screens.FOREST), app.getHud(Huds.STANDARD));
        // TODO: continue movement if button is pressed
    }
}
