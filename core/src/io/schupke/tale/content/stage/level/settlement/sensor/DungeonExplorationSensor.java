package io.schupke.tale.content.stage.level.settlement.sensor;

import com.badlogic.gdx.math.Vector2;
import io.schupke.tale.base.entity.Sensor;
import io.schupke.tale.base.entity.Triggerable;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.base.world.BaseWorld;
import io.schupke.tale.content.stage.level.settlement.event.SettlementEventHandler;

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
