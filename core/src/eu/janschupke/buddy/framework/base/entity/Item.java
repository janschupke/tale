package eu.janschupke.buddy.framework.base.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import eu.janschupke.buddy.framework.base.world.BaseWorld;
import eu.janschupke.buddy.framework.config.Config;
import eu.janschupke.buddy.framework.util.WorldObjectFactory;

/**
 * Base class for all in-game items.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class Item extends WorldObject {
    private Config.Items tag;

    public Item(BaseWorld world, Texture texture, Vector2 size, Config.Items tag) {
        super(world, texture, size);
        this.tag = tag;

        WorldObjectFactory.setCollisions(body, Config.BIT_OBSTACLE_ANY, (short) (Config.BIT_OBSTACLE_ANY | Config.BIT_UNIT_ANY));
        body.setType(BodyDef.BodyType.KinematicBody);
    }

    public Item(BaseWorld world, Texture texture, Config.Items tag) {
        this(world, texture, Config.DEFAULT_ITEM_SIZE, tag);
    }

    @Override
    public void update(float delta) {
    }

    @Override
    public void draw(Batch batch) {
        sprite.draw(batch, body);
    }

    @Override
    public String toString() {
        return description;
    }

    public Config.Items getTag() {
        return tag;
    }
}

