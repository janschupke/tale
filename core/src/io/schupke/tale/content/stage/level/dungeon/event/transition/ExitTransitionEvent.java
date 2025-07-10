package io.schupke.tale.content.stage.level.dungeon.event.transition;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.TransitionEvent;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.base.utility.Utility;
import io.schupke.tale.content.config.enumeration.Huds;
import io.schupke.tale.content.config.enumeration.Screens;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Event for exiting the dungeon.
 * Handles dungeon exit transitions and level completion.
 */
public class ExitTransitionEvent extends TransitionEvent {
    public ExitTransitionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.DUNGEON_TRANSITION_EXIT, ((BaseScreen) app.getScreen()).getTag());
        Utility.transitionScreens(app, app.getScreenInstance(Screens.OUTRO), app.getHud(Huds.OUTRO));
        // Stop any harpsi music, if playing.
        app.getResourceManager().getMusicHandler().stopHarpsichord();
    }

    @Override
    protected void updateInteractions() {

    }
}
