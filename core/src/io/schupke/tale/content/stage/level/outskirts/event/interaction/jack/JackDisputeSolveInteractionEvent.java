package io.schupke.tale.content.stage.level.outskirts.event.interaction.jack;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.quest.QuestChain;
import io.schupke.tale.base.container.quest.enumeration.TaskStatus;
import io.schupke.tale.base.event.InteractionEvent;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.ItemTags;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;
import io.schupke.tale.content.config.enumeration.tags.InteractionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;
import io.schupke.tale.content.stage.level.outskirts.OutskirtsScreen;
import io.schupke.tale.content.stage.level.outskirts.quest.OutskirtsQuestManager;

/**
 * Jack's dispute quest was solved.
 *
 * @author jan.schupke@gmail.com
 */
public class JackDisputeSolveInteractionEvent extends InteractionEvent {
    public JackDisputeSolveInteractionEvent(final App app) {
        super(app);
    }

    @Override
    protected void updateMessages() {

    }

    @Override
    protected void updateQuests() {
        QuestChain chain = ((OutskirtsQuestManager) ((OutskirtsScreen) app.getScreen()).getQuestManager()).getJackQuestChain();
        chain.getActiveQuest().getTasks().get(2).setStatus(TaskStatus.DONE);
        chain.transition();
    }

    @Override
    protected void updateGameState() {
        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_INTERACTION_JACK_DISPUTE_SOLVE, ((BaseScreen) app.getScreen()).getTag());
        app.getGameState().getInventory().removeItem(ItemTags.CAVE_BOOK);
    }

    @Override
    protected void updateInteractions() {
        Interaction jackInteraction = app.getInteraction(InteractionTags.OUTSKIRTS_JACK);
        jackInteraction.getSituation(SituationTags.OUTSKIRTS_JACK_TALK)
                .getDecision(DecisionTags.OUTSKIRTS_JACK_TALK_BOOK_GIVE).setAvailable(false);
        jackInteraction.getSituation(SituationTags.OUTSKIRTS_JACK_CRONE)
                .getDecision(DecisionTags.OUTSKIRTS_JACK_TALK_BOOK_GIVE).setAvailable(false);
    }
}
