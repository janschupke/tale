package eu.janschupke.tale.base.entity;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import eu.janschupke.tale.base.utility.WorldObjectFactory;
import eu.janschupke.tale.base.world.BaseWorld;

/**
 * Basic world entity, encapsulating everything that is represented through any sort of Box2D body.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class WorldEntity {
    protected String interactionHint;
    protected BaseWorld world;
    protected Body body;
    protected Vector2 defaultPosition = new Vector2(0, 0);
    protected Vector2 size;

    /**
     * Creates the entity with circular Box2D body.
     * @param world Box2D world instance.
     * @param radius Body radius.
     */
    public WorldEntity(BaseWorld world, int radius) {
        this.world = world;
        this.size = new Vector2(radius, radius);
        this.interactionHint = world.getScreen().getApp().getLang().get("hint.global.interact");
        body = WorldObjectFactory.createCircle(world.getBoxWorld(), radius, defaultPosition, BodyDef.BodyType.DynamicBody, true);
        body.setUserData(this);
    }

    /**
     * Creates the entity with box-shaped Box2D body.
     * @param world Box2D world instance.
     * @param size Body size.
     */
    public WorldEntity(BaseWorld world, Vector2 size) {
        this.world = world;
        this.size = size;
        this.interactionHint = world.getScreen().getApp().getLang().get("hint.global.interact");
        body = WorldObjectFactory.createBox(world.getBoxWorld(), size, defaultPosition, BodyDef.BodyType.DynamicBody, true);
        body.setUserData(this);
    }

    /**
     * Sets the entity's position within the world.
     * Implementation varies and is specified in subclasses.
     *
     * @param x Position x coordinate within the world.
     * @param y Position y coordinate within the world.
     */
    public abstract void setPosition(float x, float y);

    /**
     * Retrieves interaction hint that is shown on the screen,
     * after player comes to contact with this entity.
     * Only used if the entity is triggerable.
     *
     * @return Interaction hint message.
     */
    public String getInteractionHint() {
        return interactionHint;
    }

    public Body getBody() {
        return body;
    }

    public void dispose() {
    }
}
