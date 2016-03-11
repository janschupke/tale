package eu.janschupke.tale.content.stage.level.dungeon.event.interaction.gate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import eu.janschupke.tale.content.config.enumeration.ItemTags;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.content.stage.level.dungeon.DungeonScreen;
import eu.janschupke.tale.content.stage.level.dungeon.obstacle.gate.GateObstacle;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.WorldEntity;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.screen.BaseScreen;

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
                ((GateObstacle) obstacle).setTexture(new Texture(Gdx.files.internal("textures/levels/dungeon/terrain/gate-open.png")));
                // For collision removal.
                obstacle.getBody().getFixtureList().get(0).setSensor(true);
                break;
            }
        }
    }
}
