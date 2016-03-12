package eu.janschupke.tale.content.stage.level.dungeon.event.interaction.gate;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.entity.WorldEntity;
import eu.janschupke.tale.base.event.InteractionEvent;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.content.config.enumeration.ItemTags;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.content.stage.level.dungeon.DungeonScreen;
import eu.janschupke.tale.content.stage.level.dungeon.obstacle.gate.GateObstacle;

/**
 * Opening the gate.
 *
 * @author jan.schupke@gmail.com
 */
public class GateOpenInteractionEvent extends InteractionEvent {
    public GateOpenInteractionEvent(final App app) {
        super(app);
    }

    @Override
    protected void updateMessages() {

    }

    @Override
    protected void updateQuests() {

    }

    @Override
    protected void updateGameState() {
        app.getGameLog().addEntry(GameEventTags.DUNGEON_INTERACTION_GATE_OPEN, ((BaseScreen) app.getScreen()).getTag());
        app.getGameState().getInventory().removeItem(ItemTags.DUNGEON_GATE_KEY);
        updateGateObject();
        app.getResourceManager().getSoundHandler().playSound(
                app.getResourceManager().getSoundHandler().getGateSound());
    }

    @Override
    protected void updateInteractions() {
        Interaction gateInteraction = app.getInteraction(InteractionTags.DUNGEON_GATE);
        gateInteraction.getSituation(SituationTags.DUNGEON_GATE_INVESTIGATE)
                .getDecision(DecisionTags.DUNGEON_GATE_OPEN).setAvailable(false);
    }

    private void updateGateObject() {
        for (WorldEntity obstacle : ((DungeonScreen) app.getScreen()).getWorld().getObstacles()) {
            if (obstacle instanceof GateObstacle) {
                ((GateObstacle) obstacle).setTexture(app.getResourceManager().getTextureHandler().getDungeonGateOpenTexture());
                // For collision removal.
                obstacle.getBody().getFixtureList().get(0).setSensor(true);
                break;
            }
        }
    }
}
