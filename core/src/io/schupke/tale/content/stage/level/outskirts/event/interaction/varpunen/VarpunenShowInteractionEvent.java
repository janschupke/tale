package io.schupke.tale.content.stage.level.outskirts.event.interaction.varpunen;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.quest.QuestChain;
import io.schupke.tale.base.container.quest.enumeration.TaskStatus;
import io.schupke.tale.base.event.InteractionEvent;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;
import io.schupke.tale.content.config.enumeration.tags.InteractionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;
import io.schupke.tale.content.stage.level.outskirts.OutskirtsScreen;
import io.schupke.tale.content.stage.level.outskirts.quest.OutskirtsQuestManager;

/**
 * General event that occurs when the Varpunen note is shown.
 *
 * @author jan.schupke@gmail.com
 */
public class VarpunenShowInteractionEvent extends InteractionEvent {
    public VarpunenShowInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_INTERACTION_CRONE_VARPUNEN_SHOW, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {
        Interaction croneInteraction = app.getInteraction(InteractionTags.OUTSKIRTS_CRONE);
        croneInteraction.getSituation(SituationTags.OUTSKIRTS_CRONE_TALK)
                .getDecision(DecisionTags.OUTSKIRTS_CRONE_VARPUNEN_SHOW).setAvailable(false);
        croneInteraction.getSituation(SituationTags.OUTSKIRTS_CRONE_TALK)
                .getDecision(DecisionTags.OUTSKIRTS_CRONE_VARPUNEN_GIVE).setAvailable(true);
        croneInteraction.getSituation(SituationTags.OUTSKIRTS_CRONE_VARPUNEN_SHOW)
                .getDecision(DecisionTags.OUTSKIRTS_CRONE_VARPUNEN_GIVE).setAvailable(true);
    }
}
