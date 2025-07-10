package io.schupke.tale.content.stage.level.outskirts.event.transition;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.quest.QuestChain;
import io.schupke.tale.base.container.quest.enumeration.TaskStatus;
import io.schupke.tale.base.event.TransitionEvent;
import io.schupke.tale.base.interaction.InteractionSwitch;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.base.utility.Utility;
import io.schupke.tale.content.config.Config;
import io.schupke.tale.content.config.enumeration.Huds;
import io.schupke.tale.content.config.enumeration.Screens;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;
import io.schupke.tale.content.stage.level.outskirts.OutskirtsScreen;
import io.schupke.tale.content.stage.level.outskirts.quest.OutskirtsQuestManager;

/**
 * Event for screen transition from Outskirts to Cave.
 *
 * @author jan.schupke@gmail.com
 */
public class CaveTransitionEvent extends TransitionEvent {
    public CaveTransitionEvent(final App app) {
        super(app);
    }

    @Override
    protected void updateMessages() {

    }

    @Override
    protected void updateQuests() {
        if (app.getGameState().getGlobalLevelState().isDisputeAccepted()) {
            QuestChain chain = ((OutskirtsQuestManager) ((OutskirtsScreen) app.getScreen()).getQuestManager()).getJackQuestChain();
            if (!chain.getActiveQuest().getTasks().get(0).getStatus().equals(TaskStatus.DONE)) {
                chain.getActiveQuest().getTasks().get(0).setStatus(TaskStatus.DONE);
            }
        }
    }

    @Override
    protected void updateGameState() {
        app.getGameState().getGlobalLevelState().setCaveExplored(true);

        InteractionSwitch.getTriggerable().endInteraction(app);
        InteractionSwitch.disable(app);

        Utility.preservePlayerMovement(app, Screens.CAVE);
        Utility.transitionScreens(app, app.getScreenInstance(Screens.CAVE), app.getHud(Huds.STANDARD));

        app.getGameState().getCurrentLevel().getWorld().getPlayerUnit().getBody().setLinearVelocity(0, Config.OBJECT_MAX_SPEED);
        app.getGameState().getCurrentLevel().getWorld().getPlayerUnit().moveUp();
        app.getGameState().getCurrentLevel().getWorld().getPlayerUnit().stop();

        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_TRANSITION_CAVE, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
