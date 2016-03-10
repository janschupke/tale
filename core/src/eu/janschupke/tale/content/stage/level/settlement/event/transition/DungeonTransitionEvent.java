package eu.janschupke.tale.content.stage.level.settlement.event.transition;

import eu.janschupke.tale.content.config.Config;
import eu.janschupke.tale.content.config.enumeration.Huds;
import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.TransitionEvent;
import eu.janschupke.tale.framework.interaction.InteractionSwitch;
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
    }

    @Override
    protected void updateMessages() {

    }

    @Override
    protected void updateQuests() {

    }

    @Override
    protected void updateGameState() {
        InteractionSwitch.getTriggerable().endInteraction(app);
        InteractionSwitch.disable(app);

        Utility.preservePlayerMovement(app, Screens.DUNGEON);
        Utility.transitionScreens(app, app.getScreenInstance(Screens.DUNGEON), app.getHud(Huds.STANDARD));

        // FIXME: rather blasphemous, though deadlines are real.
        app.getGameState().getCurrentLevel().getWorld().getPlayerUnit().getBody().setLinearVelocity(0, Config.OBJECT_MAX_SPEED);
        app.getGameState().getCurrentLevel().getWorld().getPlayerUnit().moveDown();
        app.getGameState().getCurrentLevel().getWorld().getPlayerUnit().stop();

        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_TRANSITION_CAVE, ((BaseScreen) app.getScreen()).getTag());

        app.getGameLog().addEntry(GameEventTags.SETTLEMENT_TRANSITION_DUNGEON, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
