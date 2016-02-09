package eu.janschupke.buddy.content.stage.level.forest.sensor;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.framework.base.entity.Sensor;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

/**
 * A sensor that triggers cave lore in the tutorial area.
 */
public class CaveSensor extends Sensor implements Triggerable {
    public CaveSensor(BaseWorld world, Vector2 size) {
        super(world, size);
    }

    @Override
    public void engage() {
//        ((ForestEventHandler)((GameScreen)world.getScreen()).getLevelEventHandler()).triggerCaveLore();
    }

    @Override
    public void disengage() {
    }
}
