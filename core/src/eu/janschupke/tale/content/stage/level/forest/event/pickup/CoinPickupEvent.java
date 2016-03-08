package eu.janschupke.tale.content.stage.level.forest.event.pickup;

import com.badlogic.gdx.Gdx;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.content.stage.level.forest.ForestScreen;
import eu.janschupke.tale.content.stage.level.forest.obstacle.InitialWall;
import eu.janschupke.tale.content.stage.level.forest.quest.ForestQuestManager;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.quest.QuestChain;
import eu.janschupke.tale.framework.container.quest.enumeration.TaskStatus;
import eu.janschupke.tale.framework.entity.Wall;
import eu.janschupke.tale.framework.entity.WorldEntity;
import eu.janschupke.tale.framework.event.PickupEvent;
import eu.janschupke.tale.framework.screen.BaseScreen;
import eu.janschupke.tale.framework.ui.dialog.InfoDialog;

/**
 * Event that picks up the coin from the ground.
 *
 * @author jan.schupke@gmail.com
 */
public class CoinPickupEvent extends PickupEvent {
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

    private PickupDialog pickupDialog;

    public CoinPickupEvent(final App app) {
        super(app, app.getLang().get("level.forest.event.pickup.text"));
        pickupDialog = new PickupDialog(app);
        withDialog = true;
    }

    @Override
    protected void updateMessages() {
        showDialog(pickupDialog);
        addEventMessage();
    }

    @Override
    protected void updateQuests() {
        QuestChain chain = ((ForestQuestManager) ((ForestScreen) app.getScreen()).getQuestManager()).getIntroQuestChain();
        ((ForestScreen) app.getScreen()).getQuestManager().initQuestChain(chain);

        // Task to pick up the coin is already done.
        chain.getActiveQuest().getTasks().get(0).setStatus(TaskStatus.DONE);
    }

    @Override
    protected void updateGameState() {
        removeInitialWall();
        app.getGameState().getGlobalLevelState().clearCurrentHint();
        app.getGameLog().addEntry(GameEventTags.FOREST_COIN_PICKUP, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

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
}
