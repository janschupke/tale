package eu.janschupke.buddy.content.stage.level.settlement.sensor;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.framework.base.entity.Sensor;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

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
    }

    @Override
    public void disengage() {

    }

    @Override
    public Interaction getInteraction() {
        return null;
    }
}