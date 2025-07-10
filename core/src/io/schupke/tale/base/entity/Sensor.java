package io.schupke.tale.base.entity;

import com.badlogic.gdx.math.Vector2;

import io.schupke.tale.base.utility.WorldObjectFactory;
import io.schupke.tale.base.world.BaseWorld;
import io.schupke.tale.content.config.Config;

/**
 * Represents a sensor in the game world.
 * Provides trigger detection without physical collision.
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
