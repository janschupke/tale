package io.schupke.tale.content.stage.level.forest.event.transition;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.TransitionEvent;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.base.utility.Utility;
import io.schupke.tale.content.config.enumeration.Huds;
import io.schupke.tale.content.config.enumeration.Screens;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Event for screen transition from Forest to Outskirts.
 *
 * @author jan.schupke@gmail.com
 */
public class OutskirtsTransitionEvent extends TransitionEvent {
    public OutskirtsTransitionEvent(final App app) {
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
        Utility.preservePlayerMovement(app, Screens.OUTSKIRTS);
        Utility.transitionScreens(app, app.getScreenInstance(Screens.OUTSKIRTS), app.getHud(Huds.STANDARD));
        app.getGameLog().addEntry(GameEventTags.FOREST_TRANSITION_OUTSKIRTS, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
