package eu.janschupke.tale.content.stage.level.cave.event.transition;

import eu.janschupke.tale.content.config.enumeration.Huds;
import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.TransitionEvent;
import eu.janschupke.tale.framework.screen.BaseScreen;
import eu.janschupke.tale.framework.utility.Utility;

/**
 * Event for the transition from Cave to Outskirts.
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
        app.getGameLog().addEntry(GameEventTags.CAVE_TRANSITION_OUTSKIRTS, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
