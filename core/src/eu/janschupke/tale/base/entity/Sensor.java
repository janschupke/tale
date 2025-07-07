package eu.janschupke.tale.base.entity;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.base.utility.WorldObjectFactory;
import eu.janschupke.tale.base.world.BaseWorld;
import eu.janschupke.tale.content.config.Config;

/**
 * Base class for all in-game world sensors.
 * Detects contacts, but does not collide.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class Sensor extends WorldEntity {
    public Sensor(BaseWorld world, Vector2 size) {
        super(world, size);
        WorldObjectFactory.setCollisions(body, Config.BIT_OBSTACLE_ANY, Config.BIT_UNIT_PLAYER);
        WorldObjectFactory.setSensor(body, true);
    }

    @Override
    public void setPosition(float x, float y) {
        Vector2 position = new Vector2(x + size.x / 2.0f, y + size.y / 2.0f);
        body.setTransform(position, body.getAngle());
    }
}
