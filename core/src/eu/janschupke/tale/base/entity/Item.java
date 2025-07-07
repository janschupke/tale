package eu.janschupke.tale.base.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import eu.janschupke.tale.base.utility.WorldObjectFactory;
import eu.janschupke.tale.base.world.BaseWorld;
import eu.janschupke.tale.content.config.Config;
import eu.janschupke.tale.content.config.enumeration.ItemTags;

/**
 * Base class for all in-game items.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class Item extends WorldObject {
    private ItemTags tag;

    public Item(BaseWorld world, Texture texture, Vector2 size, ItemTags tag) {
        super(world, texture, size);
        this.tag = tag;

        WorldObjectFactory.setCollisions(body, Config.BIT_OBSTACLE_ANY, (short) (Config.BIT_OBSTACLE_ANY | Config.BIT_UNIT_ANY));
        body.setType(BodyDef.BodyType.KinematicBody);
    }

    public Item(BaseWorld world, Texture texture, ItemTags tag) {
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

    public ItemTags getTag() {
        return tag;
    }
}

