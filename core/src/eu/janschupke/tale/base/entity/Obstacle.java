package eu.janschupke.tale.base.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import eu.janschupke.tale.base.utility.WorldObjectFactory;
import eu.janschupke.tale.base.world.BaseWorld;
import eu.janschupke.tale.content.config.Config;

/**
 * Non-movable colliding world object.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class Obstacle extends WorldObject {
    public Obstacle(BaseWorld world, Texture texture, int radius) {
        super(world, texture, radius);
        initCollisions();
    }

    public Obstacle(BaseWorld world, Texture texture, Vector2 size) {
        super(world, texture, size);
        initCollisions();
    }

    private void initCollisions() {
        WorldObjectFactory.setCollisions(body, Config.BIT_OBSTACLE_ANY, (short) (Config.BIT_OBSTACLE_ANY | Config.BIT_UNIT_ANY));
        body.setType(BodyDef.BodyType.StaticBody);
    }

    @Override
    public void draw(Batch batch) {
        sprite.draw(batch, body);
    }
}
