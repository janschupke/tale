package io.schupke.tale.content.stage.level.dungeon.event.interaction.gate;

import io.schupke.tale.base.App;
import io.schupke.tale.base.entity.WorldEntity;
import io.schupke.tale.base.event.InteractionEvent;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.ItemTags;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;
import io.schupke.tale.content.config.enumeration.tags.InteractionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;
import io.schupke.tale.content.stage.level.dungeon.DungeonScreen;
import io.schupke.tale.content.stage.level.dungeon.obstacle.gate.GateObstacle;

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
