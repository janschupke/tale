package eu.janschupke.buddy.content.stage.level.forest.event;

import com.badlogic.gdx.Gdx;
import eu.janschupke.buddy.content.stage.level.forest.ForestLevelState;
import eu.janschupke.buddy.content.stage.level.forest.ForestScreen;
import eu.janschupke.buddy.content.stage.level.forest.obstacle.QuestWall;
import eu.janschupke.buddy.content.stage.level.forest.quest.ForestQuestManager;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Wall;
import eu.janschupke.buddy.framework.base.entity.WorldEntity;
import eu.janschupke.buddy.framework.base.entity.container.QuestChain;
import eu.janschupke.buddy.framework.base.event.BaseEvent;
import eu.janschupke.buddy.framework.config.enumeration.ItemTags;
import eu.janschupke.buddy.framework.config.enumeration.interaction.DecisionTags;
import eu.janschupke.buddy.framework.config.enumeration.interaction.InteractionTags;
import eu.janschupke.buddy.framework.config.enumeration.interaction.SituationTags;

/**
 * Event for the coin delivery to the Ukko unit.
 *
 * @author jan.schupke@gmail.com
 */
public class UkkoDeliveryEvent extends BaseEvent {
    public UkkoDeliveryEvent(final App app) {
        super(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
        Gdx.app.debug("UkkoDeliveryEvent#trigger", "Delivering the coin");

        updateQuest();
        updateGameState();
        updateInteractions();
    }

    /**
     * Updates quest status accordingly to the actions.
     */
    private void updateQuest() {
        QuestChain chain = ((ForestQuestManager) ((ForestScreen) app.getScreen()).getQuestManager()).getIntroQuestChain();
        chain.transition();
    }

    /**
     * Updates game state to conform actions that occurred during this event.
     */
    private void updateGameState() {
        ((ForestLevelState) ((ForestScreen) app.getScreen()).getLevelState()).setCoinDelivered(true);
        app.getGameState().getInventory().removeItem(ItemTags.FOREST_GOLD_COIN);
        removeQuestWall();
    }

    /**
     * Updates the availability of interaction decisions.
     */
    private void updateInteractions() {
        app.getInteraction(InteractionTags.FOREST_UKKO).getSituation(SituationTags.FOREST_UKKO_TALK)
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
