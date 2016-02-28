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
import eu.janschupke.buddy.framework.config.Config;

/**
 * Event for the coin delivery to the Ukko unit.
 *
 * @author jan.schupke@gmail.com
 */
public class UkkoDeliveryEvent extends BaseEvent {
    public UkkoDeliveryEvent(final App app) {
        super(app, "");
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        super.trigger();
        Gdx.app.debug("UkkoDeliveryEvent#trigger", "Delivering the coin");

        app.getGameState().getInventory().removeItem(Config.Items.FOREST_GOLD_COIN);
        QuestChain chain = ((ForestQuestManager) ((ForestScreen) app.getScreen()).getQuestManager()).getIntroQuestChain();
        chain.transition();
        ((ForestLevelState) ((ForestScreen) app.getScreen()).getLevelState()).setCoinDelivered(true);
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
