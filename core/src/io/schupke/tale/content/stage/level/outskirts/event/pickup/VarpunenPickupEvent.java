package io.schupke.tale.content.stage.level.outskirts.event.pickup;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.quest.QuestChain;
import io.schupke.tale.base.event.PickupEvent;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;
import io.schupke.tale.content.config.enumeration.tags.InteractionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;
import io.schupke.tale.content.stage.level.outskirts.OutskirtsScreen;
import io.schupke.tale.content.stage.level.outskirts.quest.OutskirtsQuestManager;

/**
 * Event for the Varpunen note pickup.
 *
 * @author jan.schupke@gmail.com
 */
public class VarpunenPickupEvent extends PickupEvent {
    public VarpunenPickupEvent(final App app) {
        super(app);
    }

    @Override
    protected void updateMessages() {

    }

    @Override
    protected void updateQuests() {
        QuestChain chain = ((OutskirtsQuestManager) ((OutskirtsScreen) app.getScreen()).getQuestManager()).getNoteQuestChain();
        ((OutskirtsScreen) app.getScreen()).getQuestManager().initQuestChain(chain);
    }

    @Override
    protected void updateGameState() {
        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_PICKUP_VARPUNEN, ((BaseScreen) app.getScreen()).getTag());
        app.getResourceManager().getSoundHandler().playSound(
                app.getResourceManager().getSoundHandler().getVarpunenSound());
    }

    @Override
    protected void updateInteractions() {
        Interaction croneInteraction = app.getInteraction(InteractionTags.OUTSKIRTS_CRONE);
        croneInteraction.getSituation(SituationTags.OUTSKIRTS_CRONE_TALK)
                .getDecision(DecisionTags.OUTSKIRTS_CRONE_VARPUNEN_SHOW).setAvailable(true);
    }
}
