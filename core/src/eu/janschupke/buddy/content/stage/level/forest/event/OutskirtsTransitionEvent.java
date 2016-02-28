package eu.janschupke.buddy.content.stage.level.forest.event;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;
import eu.janschupke.buddy.framework.config.Config;
import eu.janschupke.buddy.framework.config.enumeration.Huds;
import eu.janschupke.buddy.framework.config.enumeration.Screens;
import eu.janschupke.buddy.framework.util.Utility;

/**
 * Event for screen transition from Forest to Outskirts.
 *
 * @author jan.schupke@gmail.com
 */
public class OutskirtsTransitionEvent extends BaseEvent {
    public OutskirtsTransitionEvent(final App app) {
        super(app);
        repeatable = true;
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
        // TODO: refactor
        app.getGameState().getCurrentLevel().getWorld().getPlayerUnit().moveDown();
        app.getGameState().getCurrentLevel().getWorld().getPlayerUnit().stop();
        app.getGameState().getCurrentLevel().getWorld().getPlayerUnit().getBody()
                .setLinearVelocity(0, -Config.PLAYER_SCREEN_TRANSITION_VELOCITY);

        Utility.transitionScreens(app, app.getScreenInstance(Screens.OUTSKIRTS), app.getHud(Huds.STANDARD));
        // TODO: continue movement if button is pressed
    }
}
