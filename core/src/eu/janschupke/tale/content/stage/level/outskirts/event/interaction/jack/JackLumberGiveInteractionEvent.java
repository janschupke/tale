package eu.janschupke.tale.content.stage.level.outskirts.event.interaction.jack;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.container.quest.QuestChain;
import eu.janschupke.tale.base.container.quest.enumeration.TaskStatus;
import eu.janschupke.tale.base.event.InteractionEvent;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.content.config.enumeration.ItemTags;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.content.stage.level.outskirts.OutskirtsScreen;
import eu.janschupke.tale.content.stage.level.outskirts.quest.OutskirtsQuestManager;

/**
 * Event for Jack giving lumber in the outskirts.
 * Handles quest completion and item exchange.
 */
public class JackLumberGiveInteractionEvent extends InteractionEvent {
    public JackLumberGiveInteractionEvent(final App app) {
        super(app);
    }

    @Override
    protected void updateMessages() {

    }

    @Override
    protected void updateQuests() {
        QuestChain chain = ((OutskirtsQuestManager) ((OutskirtsScreen) app.getScreen()).getQuestManager()).getJackQuestChain();
        chain.getActiveQuest().getTasks().get(1).setStatus(TaskStatus.DONE);
        chain.getActiveQuest().setStatus(TaskStatus.DONE);
    }

    @Override
    protected void updateGameState() {
        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_INTERACTION_JACK_LUMBER_GIVE, ((BaseScreen) app.getScreen()).getTag());
        app.getGameState().getInventory().removeItem(ItemTags.OUTSKIRTS_LUMBER);
    }

    @Override
    protected void updateInteractions() {
        Interaction jackInteraction = app.getInteraction(InteractionTags.OUTSKIRTS_JACK);

        jackInteraction.getSituation(SituationTags.OUTSKIRTS_JACK_TALK)
                .getDecision(DecisionTags.OUTSKIRTS_JACK_LUMBER_GIVE).setAvailable(false);
        jackInteraction.getSituation(SituationTags.OUTSKIRTS_JACK_CRONE)
                .getDecision(DecisionTags.OUTSKIRTS_JACK_LUMBER_GIVE).setAvailable(false);
        jackInteraction.getSituation(SituationTags.OUTSKIRTS_JACK_LUMBER_ACCEPT)
                .getDecision(DecisionTags.OUTSKIRTS_JACK_LUMBER_GIVE).setAvailable(false);
        jackInteraction.getSituation(SituationTags.OUTSKIRTS_JACK_TALK)
                .getDecision(DecisionTags.OUTSKIRTS_JACK_TALK_DISPUTE).setAvailable(true);
    }
}
