package eu.janschupke.tale.content.stage.level.settlement.sensor;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.content.stage.level.settlement.SettlementEventHandler;
import eu.janschupke.tale.framework.base.entity.Sensor;
import eu.janschupke.tale.framework.base.entity.Triggerable;
import eu.janschupke.tale.framework.base.interaction.Interaction;
import eu.janschupke.tale.framework.base.screen.GameScreen;
import eu.janschupke.tale.framework.base.world.BaseWorld;

/**
 * Exploration sensor for the dungeon area.
 *
 * @author jan.schupke@gmail.com
 */
public class DungeonExplorationSensor extends Sensor implements Triggerable {
    public DungeonExplorationSensor(BaseWorld world, Vector2 size) {
        super(world, size);
    }

    @Override
    public void engage() {
        ((SettlementEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getDungeonExplorationEvent().trigger();
    }

    @Override
    public void disengage() {

    }

    @Override
    public Interaction getInteraction() {
        return null;
    }
}
