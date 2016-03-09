package eu.janschupke.tale.content.stage.level.outskirts.event.interaction.varpunen;

import eu.janschupke.tale.content.config.enumeration.ItemTags;
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
 * Occurs when the Varpunen note is given to the crone.
 *
 * @author jan.schupke@gmail.com
 */
public class VarpunenGiveInteractionEvent extends InteractionEvent {
    public VarpunenGiveInteractionEvent(App app) {
        super(app);
    }

    @Override
    protected void updateMessages() {

    }

    @Override
    protected void updateQuests() {
        QuestChain chain = ((OutskirtsQuestManager) ((OutskirtsScreen) app.getScreen()).getQuestManager()).getNoteQuestChain();
        chain.getActiveQuest().getTasks().get(0).setStatus(TaskStatus.DONE);
        chain.transition();
    }

    @Override
    protected void updateGameState() {
        app.getGameState().getInventory().removeItem(ItemTags.OUTSKIRTS_VARPUNEN);
        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_INTERACTION_CRONE_VARPUNEN_SHOW, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {
        Interaction croneInteraction = app.getInteraction(InteractionTags.OUTSKIRTS_CRONE);
        croneInteraction.getSituation(SituationTags.OUTSKIRTS_CRONE_TALK)
                .getDecision(DecisionTags.OUTSKIRTS_CRONE_VARPUNEN_GIVE).setAvailable(false);
    }
}
