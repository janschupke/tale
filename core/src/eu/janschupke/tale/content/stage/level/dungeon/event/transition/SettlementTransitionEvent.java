package eu.janschupke.tale.content.stage.level.dungeon.event.transition;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.event.TransitionEvent;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.base.utility.Utility;
import eu.janschupke.tale.content.config.Config;
import eu.janschupke.tale.content.config.enumeration.Huds;
import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Event for transitioning from dungeon to settlement.
 * Handles level transitions and player movement between areas.
 */
public class SettlementTransitionEvent extends TransitionEvent {
    public SettlementTransitionEvent(final App app) {
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
        Utility.preservePlayerMovement(app, Screens.SETTLEMENT);
        Utility.transitionScreens(app, app.getScreenInstance(Screens.SETTLEMENT), app.getHud(Huds.STANDARD));

        app.getGameState().getCurrentLevel().getWorld().getPlayerUnit().getBody()
                .setLinearVelocity(-Config.OBJECT_MAX_SPEED, Config.OBJECT_MAX_SPEED);
        app.getGameState().getCurrentLevel().getWorld().getPlayerUnit().moveUp();
        app.getGameState().getCurrentLevel().getWorld().getPlayerUnit().stop();

        // Stop any harpsi music, if playing.
        app.getResourceManager().getMusicHandler().stopHarpsichord();

        app.getGameLog().addEntry(GameEventTags.DUNGEON_TRANSITION_SETTLEMENT, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
