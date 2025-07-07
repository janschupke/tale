package eu.janschupke.tale.content.stage.level.forest.event.pickup;

import com.badlogic.gdx.Gdx;
import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.container.quest.QuestChain;
import eu.janschupke.tale.base.container.quest.enumeration.TaskStatus;
import eu.janschupke.tale.base.entity.Wall;
import eu.janschupke.tale.base.entity.WorldEntity;
import eu.janschupke.tale.base.event.PickupEvent;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.base.ui.dialog.InfoDialog;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.content.stage.level.forest.ForestScreen;
import eu.janschupke.tale.content.stage.level.forest.obstacle.InitialWall;
import eu.janschupke.tale.content.stage.level.forest.quest.ForestQuestManager;

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
        app.getGameLog().addEntry(GameEventTags.FOREST_PICKUP_COIN, ((BaseScreen) app.getScreen()).getTag());
        app.getResourceManager().getSoundHandler().playSound(
                app.getResourceManager().getSoundHandler().getCoinSound());
    }

    @Override
    protected void updateInteractions() {
        Interaction ukkoInteraction = app.getInteraction(InteractionTags.FOREST_UKKO);
        ukkoInteraction.getSituation(SituationTags.FOREST_UKKO_TALK)
                .getDecision(DecisionTags.FOREST_UKKO_DELIVERY).setAvailable(true);
        ukkoInteraction.getSituation(SituationTags.FOREST_UKKO_DISCUSS)
                .getDecision(DecisionTags.FOREST_UKKO_DELIVERY).setAvailable(true);
    }

    /**
     * Removes the initial invisible wall from the world.
     */
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
