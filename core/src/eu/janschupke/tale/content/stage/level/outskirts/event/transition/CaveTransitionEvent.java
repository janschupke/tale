package eu.janschupke.tale.content.stage.level.outskirts.event.transition;

import eu.janschupke.tale.content.config.enumeration.Huds;
import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.TransitionEvent;
import eu.janschupke.tale.framework.interaction.InteractionSwitch;
import eu.janschupke.tale.framework.screen.BaseScreen;
import eu.janschupke.tale.framework.utility.Utility;

/**
 * Event for screen transition from Outskirts to Cave.
 *
 * @author jan.schupke@gmail.com
 */
public class CaveTransitionEvent extends TransitionEvent {
    public CaveTransitionEvent(final App app) {
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
        // TODO: transition NPE
        // Pushes down by 1 tile so that the body is not in contact with the cave.
        app.getGameState().getCurrentLevel().getWorld().getPlayerUnit().setPosition(
                app.getGameState().getCurrentLevel().getWorld().getPlayerUnit().getBody().getPosition().x,
                app.getGameState().getCurrentLevel().getWorld().getPlayerUnit().getBody().getPosition().y - 1
        );
        InteractionSwitch.getTriggerable().endInteraction(app);
        InteractionSwitch.disable(app);

//        Utility.preservePlayerMovement(app, Screens.CAVE);
        Utility.transitionScreens(app, app.getScreenInstance(Screens.CAVE), app.getHud(Huds.STANDARD));
        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_TRANSITION_CAVE, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
