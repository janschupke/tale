package eu.janschupke.tale.content.stage.level.outskirts.event.transition;

import eu.janschupke.tale.content.config.Config;
import eu.janschupke.tale.content.config.enumeration.Huds;
import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.content.stage.level.outskirts.OutskirtsScreen;
import eu.janschupke.tale.content.stage.level.outskirts.quest.OutskirtsQuestManager;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.quest.QuestChain;
import eu.janschupke.tale.framework.container.quest.enumeration.TaskStatus;
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
        if (app.getGameState().getGlobalLevelState().isDisputeAccepted()) {
            QuestChain chain = ((OutskirtsQuestManager) ((OutskirtsScreen) app.getScreen()).getQuestManager()).getJackQuestChain();
            chain.getActiveQuest().getTasks().get(0).setStatus(TaskStatus.DONE);
        }
    }

    @Override
    protected void updateGameState() {
        app.getGameState().getGlobalLevelState().setCaveExplored(true);

        InteractionSwitch.getTriggerable().endInteraction(app);
        InteractionSwitch.disable(app);

        Utility.preservePlayerMovement(app, Screens.CAVE);
        Utility.transitionScreens(app, app.getScreenInstance(Screens.CAVE), app.getHud(Huds.STANDARD));

        // FIXME: rather blasphemous, though deadlines are real.
        app.getGameState().getCurrentLevel().getWorld().getPlayerUnit().getBody().setLinearVelocity(0, Config.OBJECT_MAX_SPEED);
        app.getGameState().getCurrentLevel().getWorld().getPlayerUnit().moveUp();
        app.getGameState().getCurrentLevel().getWorld().getPlayerUnit().stop();

        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_TRANSITION_CAVE, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
