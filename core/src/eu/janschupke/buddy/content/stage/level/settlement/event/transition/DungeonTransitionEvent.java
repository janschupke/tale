package eu.janschupke.buddy.content.stage.level.settlement.event.transition;

import eu.janschupke.buddy.content.config.enumeration.Huds;
import eu.janschupke.buddy.content.config.enumeration.Screens;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.TransitionEvent;
import eu.janschupke.buddy.framework.util.Utility;

/**
 * Event for entering the dungeon.
 *
 * @author jan.schupke@gmail.com
 */
public class DungeonTransitionEvent extends TransitionEvent {
    public DungeonTransitionEvent(final App app) {
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
        Utility.preservePlayerMovement(app, Screens.DUNGEON);
        Utility.transitionScreens(app, app.getScreenInstance(Screens.DUNGEON), app.getHud(Huds.STANDARD));
    }

    @Override
    protected void updateInteractions() {

    }
}
