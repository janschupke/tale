package eu.janschupke.buddy.content.stage.level.forest.event;

import com.badlogic.gdx.Gdx;
import eu.janschupke.buddy.content.stage.level.forest.ForestLevelState;
import eu.janschupke.buddy.content.stage.level.forest.ForestScreen;
import eu.janschupke.buddy.content.stage.level.forest.item.coin.GoldCoinItem;
import eu.janschupke.buddy.content.stage.level.forest.obstacle.InitialWall;
import eu.janschupke.buddy.content.stage.level.forest.quest.ForestQuestManager;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Wall;
import eu.janschupke.buddy.framework.base.entity.WorldEntity;
import eu.janschupke.buddy.framework.base.entity.container.QuestChain;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;
import eu.janschupke.buddy.framework.base.event.PickupEvent;
import eu.janschupke.buddy.framework.base.ui.dialog.InfoDialog;

/**
 * Event that picks up the coin from the ground.
 *
 * @author jan.schupke@gmail.com
 */
public class CoinPickupEvent extends PickupEvent {
    private PickupDialog pickupDialog;

    public CoinPickupEvent(final App app) {
        super(app, app.getLang().get("level.forest.event.pickup.text"));
        pickupDialog = new PickupDialog(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        item = ((GoldCoinItem) InteractionSwitch.getTriggerable());
        Gdx.app.debug("CoinPickupEvent#trigger", "Picking up the coin");
        super.trigger();
        showDialog(pickupDialog);
        addEventMessage();
        QuestChain chain = ((ForestQuestManager) ((ForestScreen) app.getScreen()).getQuestManager()).getIntroQuestChain();
        ((ForestScreen) app.getScreen()).getQuestManager().initQuestChain(chain);
        ((ForestLevelState) ((ForestScreen) app.getScreen()).getLevelState()).setCoinPickedUp(true);
        removeInitialWall();
        app.getGameState().getGlobalLevelState().clearCurrentHint();
    }

    // TODO: class passing
    private void removeInitialWall() {
        for (WorldEntity obstacle : ((ForestScreen) app.getScreen()).getWorld().getObstacles()) {
            if (obstacle instanceof InitialWall) {
                Gdx.app.debug("CoinPickupEvent#removeInitialWall", "Removing wall");
                ((ForestScreen) app.getScreen()).getWorld().removeWall((Wall) obstacle);
                break;
            }
        }
    }

    /**
     * Shows after player's first item pickup.
     * Contains additional intro text.
     */
    private class PickupDialog extends InfoDialog {
        public PickupDialog(final App app) {
            super(app, app.getLang().get("level.forest.dialog.pickup.title"));
            label.setText(app.getLang().get("level.forest.event.pickup.text"));
        }
    }
}
