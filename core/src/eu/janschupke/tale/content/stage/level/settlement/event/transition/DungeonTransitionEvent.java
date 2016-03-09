package eu.janschupke.tale.content.stage.level.settlement.event.transition;

import eu.janschupke.tale.content.config.enumeration.Huds;
import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.TransitionEvent;
import eu.janschupke.tale.framework.screen.BaseScreen;
import eu.janschupke.tale.framework.utility.Utility;

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
        app.getGameLog().addEntry(GameEventTags.SETTLEMENT_TRANSITION_DUNGEON, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
