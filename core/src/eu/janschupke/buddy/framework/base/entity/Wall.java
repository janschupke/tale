package eu.janschupke.buddy.framework.base.entity;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import eu.janschupke.buddy.framework.base.world.BaseWorld;
import eu.janschupke.buddy.framework.config.Config;
import eu.janschupke.buddy.framework.util.WorldObjectFactory;

/**
 * Base class for invisible walls.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class Wall extends WorldEntity {
    public Wall(BaseWorld world, Vector2 size) {
        super(world, size);
        WorldObjectFactory.setCollisions(body, Config.BIT_OBSTACLE_ANY, (short) (Config.BIT_OBSTACLE_ANY | Config.BIT_UNIT_ANY));
        body.setType(BodyDef.BodyType.StaticBody);
    }

    /**
     * Moves the body to the exact position.
     *
     * @param x Position x coordinate within the world.
     * @param y Position y coordinate within the world.
     */
    @Override
    public void setPosition(float x, float y) {
        Vector2 position = new Vector2(x + size.x / 2.0f, y + size.y / 2.0f);
        body.setTransform(position, body.getAngle());
    }
}
