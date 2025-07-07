package eu.janschupke.tale.content.stage.level.outskirts.event.transition;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.event.TransitionEvent;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.base.utility.Utility;
import eu.janschupke.tale.content.config.enumeration.Huds;
import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Event for the transition from Outskirts to Forest.
 *
 * @author jan.schupke@gmail.com
 */
public class ForestTransitionEvent extends TransitionEvent {
    public ForestTransitionEvent(final App app) {
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
        Utility.preservePlayerMovement(app, Screens.FOREST);
        Utility.transitionScreens(app, app.getScreenInstance(Screens.FOREST), app.getHud(Huds.STANDARD));
        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_TRANSITION_FOREST, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
