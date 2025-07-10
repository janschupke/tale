package io.schupke.tale.base.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

import io.schupke.tale.base.world.BaseWorld;
import net.dermetfan.gdx.graphics.g2d.Box2DSprite;

/**
 * Base class for every object in the world, including units.
 */
public abstract class WorldObject extends WorldEntity {
    protected String description;
    protected String name;
    protected Box2DSprite sprite;

    public WorldObject(BaseWorld world, Texture texture, int radius) {
        super(world, radius);
        initSprite(texture);
    }

    public WorldObject(BaseWorld world, Texture texture, Vector2 size) {
        super(world, size);
        initSprite(texture);
    }

    private void initSprite(Texture texture) {
        sprite = new Box2DSprite();
        sprite.setSize(size.x, size.y);
        sprite.setPosition(defaultPosition.x, defaultPosition.y);
        setTexture(texture);
    }

    /**
     * Changes the object's texture.
     *
     * @param texture New texture.
     */
    public void setTexture(Texture texture) {
        sprite.setTexture(texture);
        sprite.setRegion(0, 0, texture.getWidth(), texture.getHeight());
    }

    /**
     * Updates various specific values of the object before its rendering.
     *
     * @param delta Elapsed time since last render.
     */
    public abstract void update(float delta);

    /**
     * Draws the object (its sprite) to the screen.
     *
     * @param batch Provided sprite batch.
     */
    public abstract void draw(Batch batch);

    public float getX() {
        return body.getPosition().x;
    }

    public float getY() {
        return body.getPosition().y;
    }

    /**
     * Sets the position of the object based on the provided tile coordinates within the world.
     * If the object is smaller than the size of one tile, it is centered within the tile.
     *
     * @param x Position x coordinate.
     * @param y Position y coordinate.
     */
    @Override
    public void setPosition(float x, float y) {
        // Offset for small entities, so that they are centered to the middle of the tile.
        float offset = (1.0f - getSprite().getWidth()) / 2.0f;
        // Offset is disregarded for entities that span more than 1 tile.
        if (getSprite().getWidth() > 1 && getSprite().getHeight() > 1) {
            offset = 0;
        }
        // Positioning.
        x = x + getSprite().getWidth() / 2.0f + offset;
        y = y + getSprite().getHeight() / 2.0f + offset;
        Vector2 position = new Vector2(x, y);
        body.setTransform(position, body.getAngle());
    }

    public float getWidth() {
        return sprite.getWidth();
    }

    public float getHeight() {
        return sprite.getHeight();
    }

    @Override
    public void dispose() {
        super.dispose();
        sprite.getTexture().dispose();
    }

    public Box2DSprite getSprite() {
        return sprite;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
