package eu.janschupke.tale.content.stage.level.outskirts.event.interaction.jack;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.content.stage.level.outskirts.OutskirtsScreen;
import eu.janschupke.tale.content.stage.level.outskirts.quest.OutskirtsQuestManager;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.quest.QuestChain;
import eu.janschupke.tale.framework.container.quest.enumeration.TaskStatus;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.screen.BaseScreen;

/**
 * Jack's dispute quest was accepted.
 *
 * @author jan.schupke@gmail.com
 */
public class JackDisputeAcceptInteractionEvent extends InteractionEvent {
    public JackDisputeAcceptInteractionEvent(final App app) {
        super(app);
    }

    @Override
    protected void updateMessages() {

    }

    @Override
    protected void updateQuests() {
        QuestChain chain = ((OutskirtsQuestManager) ((OutskirtsScreen) app.getScreen()).getQuestManager()).getJackQuestChain();
        chain.transition(0);

        if (app.getGameState().getGlobalLevelState().isCaveExplored()) {
            chain.getActiveQuest().getTasks().get(0).setStatus(TaskStatus.DONE);
        }
        if (app.getGameState().getGlobalLevelState().isBookPicked()) {
            chain.getActiveQuest().getTasks().get(1).setStatus(TaskStatus.DONE);
        }
    }

    @Override
    protected void updateGameState() {
        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_INTERACTION_JACK_DISPUTE_ACCEPT, ((BaseScreen) app.getScreen()).getTag());
        app.getGameState().getGlobalLevelState().setDisputeAccepted(true);
    }

    @Override
    protected void updateInteractions() {
        Interaction jackInteraction = app.getInteraction(InteractionTags.OUTSKIRTS_JACK);
        jackInteraction.getSituation(SituationTags.OUTSKIRTS_JACK_TALK)
                .getDecision(DecisionTags.OUTSKIRTS_JACK_TALK_DISPUTE).setAvailable(false);
    }
}
