package eu.janschupke.buddy.framework.base.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.framework.base.world.BaseWorld;
import net.dermetfan.gdx.graphics.g2d.Box2DSprite;

/**
 * Base class for every object in the world, including units.
 */
public abstract class WorldObject extends WorldEntity {
    protected Box2DSprite sprite;

    public WorldObject(BaseWorld world, Texture texture, Vector2 size) {
        super(world, size);

        sprite = new Box2DSprite();
        sprite.setSize(size.x, size.y);
        sprite.setPosition(defaultPosition.x, defaultPosition.y);
        setTexture(texture);
    }

    public WorldObject(BaseWorld world, Texture texture) {
        this(world, texture, new Vector2(1, 1));
    }

    /**
     * Changes the object's texture.
     * @param texture New texture.
     */
    public void setTexture(Texture texture) {
        sprite.setTexture(texture);
        sprite.setRegion(0, 0, texture.getWidth(), texture.getHeight());
    }

    public abstract void update(float delta);
    public abstract void draw(Batch batch);

    public float getX() {
        return body.getPosition().x;
    }

    public float getY() {
        return body.getPosition().y;
    }

    @Override
    public void setPosition(float x, float y) {
        Vector2 position = new Vector2(x + getSprite().getWidth() / 2.0f, y + getSprite().getHeight() / 2.0f);
        body.setTransform(position, body.getAngle());
    }

    public float getWidth() {
        return sprite.getWidth();
    }

    public float getHeight() {
        return sprite.getHeight();
    }

    public void dispose() {
        sprite.getTexture().dispose();
    }

    public Box2DSprite getSprite() {
        return sprite;
    }
}
