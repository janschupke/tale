package eu.janschupke.tale.content.stage.level.outskirts.event.pickup;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.container.quest.QuestChain;
import eu.janschupke.tale.base.event.PickupEvent;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.content.stage.level.outskirts.OutskirtsScreen;
import eu.janschupke.tale.content.stage.level.outskirts.quest.OutskirtsQuestManager;

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
