package io.schupke.tale.content.stage.level.dungeon.event.transition;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.TransitionEvent;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.base.utility.Utility;
import io.schupke.tale.content.config.Config;
import io.schupke.tale.content.config.enumeration.Huds;
import io.schupke.tale.content.config.enumeration.Screens;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

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
