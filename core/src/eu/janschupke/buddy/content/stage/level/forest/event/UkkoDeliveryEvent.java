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
        removeQuestlWall();
    }

    // TODO: class passing
    private void removeQuestlWall() {
        for (WorldEntity obstacle : ((ForestScreen) app.getScreen()).getWorld().getObstacles()) {
            if (obstacle instanceof QuestWall) {
                ((ForestScreen) app.getScreen()).getWorld().removeWall((Wall) obstacle);
                break;
            }
        }
    }
}
