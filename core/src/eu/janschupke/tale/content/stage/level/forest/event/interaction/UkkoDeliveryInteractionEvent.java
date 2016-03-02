package eu.janschupke.tale.content.stage.level.forest.event.interaction;

import eu.janschupke.tale.content.config.enumeration.ItemTags;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.content.stage.level.forest.ForestScreen;
import eu.janschupke.tale.content.stage.level.forest.obstacle.QuestWall;
import eu.janschupke.tale.content.stage.level.forest.quest.ForestQuestManager;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.Wall;
import eu.janschupke.tale.framework.entity.WorldEntity;
import eu.janschupke.tale.framework.entity.container.quest.QuestChain;
import eu.janschupke.tale.framework.event.GeneralEvent;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.screen.BaseScreen;

/**
 * Event for the coin delivery to the Ukko unit.
 *
 * @author jan.schupke@gmail.com
 */
public class UkkoDeliveryInteractionEvent extends GeneralEvent {
    public UkkoDeliveryInteractionEvent(final App app) {
        super(app);
    }

    @Override
    protected void updateMessages() {

    }

    @Override
    protected void updateQuests() {
        QuestChain chain = ((ForestQuestManager) ((ForestScreen) app.getScreen()).getQuestManager()).getIntroQuestChain();
        chain.transition();
    }

    @Override
    protected void updateGameState() {
        app.getGameState().getInventory().removeItem(ItemTags.FOREST_GOLD_COIN);
        removeQuestWall();
        app.getGameLog().addEntry(GameEventTags.FOREST_UKKO_DELIVERY_INTERACTION, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {
        Interaction ukkoInteraction = app.getInteraction(InteractionTags.FOREST_UKKO);
        ukkoInteraction.getSituation(SituationTags.FOREST_UKKO_TALK)
                .getDecision(DecisionTags.FOREST_UKKO_DELIVERY).setAvailable(false);
        ukkoInteraction.getSituation(SituationTags.FOREST_UKKO_DISCUSS)
                .getDecision(DecisionTags.FOREST_UKKO_DELIVERY).setAvailable(false);
    }

    // TODO: class passing
    private void removeQuestWall() {
        for (WorldEntity obstacle : ((ForestScreen) app.getScreen()).getWorld().getObstacles()) {
            if (obstacle instanceof QuestWall) {
                ((ForestScreen) app.getScreen()).getWorld().removeWall((Wall) obstacle);
                break;
            }
        }
    }
}
