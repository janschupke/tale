package io.schupke.tale.content.stage.level.outskirts.event.transition;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.TransitionEvent;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.base.utility.Utility;
import io.schupke.tale.content.config.enumeration.Huds;
import io.schupke.tale.content.config.enumeration.Screens;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Event for transition from Outskirts to Settlement.
 *
 * @author jan.schupke@gmail.com
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
        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_TRANSITION_SETTLEMENT, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
