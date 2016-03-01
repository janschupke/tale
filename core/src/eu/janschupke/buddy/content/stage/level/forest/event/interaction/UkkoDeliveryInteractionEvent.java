package eu.janschupke.buddy.content.stage.level.forest.event.interaction;

import eu.janschupke.buddy.content.stage.level.forest.ForestLevelState;
import eu.janschupke.buddy.content.stage.level.forest.ForestScreen;
import eu.janschupke.buddy.content.stage.level.forest.obstacle.QuestWall;
import eu.janschupke.buddy.content.stage.level.forest.quest.ForestQuestManager;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Wall;
import eu.janschupke.buddy.framework.base.entity.WorldEntity;
import eu.janschupke.buddy.framework.base.entity.container.QuestChain;
import eu.janschupke.buddy.framework.base.event.GeneralEvent;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.config.enumeration.ItemTags;
import eu.janschupke.buddy.framework.config.enumeration.tags.DecisionTags;
import eu.janschupke.buddy.framework.config.enumeration.tags.InteractionTags;
import eu.janschupke.buddy.framework.config.enumeration.tags.SituationTags;

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
        ((ForestLevelState) ((ForestScreen) app.getScreen()).getLevelState()).setCoinDelivered(true);
        app.getGameState().getInventory().removeItem(ItemTags.FOREST_GOLD_COIN);
        removeQuestWall();
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
