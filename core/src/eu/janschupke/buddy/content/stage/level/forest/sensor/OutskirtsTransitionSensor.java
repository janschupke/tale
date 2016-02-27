package eu.janschupke.buddy.content.stage.level.forest.sensor;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.framework.base.entity.Sensor;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

/**
 * Sensor for screen transition from Forest to Outskirts.
 *
 * @author jan.schupke@gmail.com
 */
public class OutskirtsTransitionSensor extends Sensor {
    public OutskirtsTransitionSensor(BaseWorld world, Vector2 size) {
        super(world, size);
    }
}
