package eu.janschupke.tale.content.stage.level.dungeon.event.transition;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.event.TransitionEvent;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.base.utility.Utility;
import eu.janschupke.tale.content.config.enumeration.Huds;
import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;

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
