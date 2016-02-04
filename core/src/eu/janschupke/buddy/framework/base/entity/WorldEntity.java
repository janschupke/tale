package eu.janschupke.buddy.framework.base.entity;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import eu.janschupke.buddy.framework.base.world.BaseWorld;
import eu.janschupke.buddy.framework.util.WorldObjectFactory;

/**
 * Basic world entity, encapsulating everything that is represented through any sort of Box2D body.
 */
public abstract class WorldEntity {
    protected String interactionHint;
    protected BaseWorld world;
    protected Body body;
    protected Vector2 defaultPosition = new Vector2(0, 0);
    protected Vector2 size;

    public WorldEntity(BaseWorld world, Vector2 size) {
        this.world = world;
        this.size = size;
        body = WorldObjectFactory.createBox(world.getBoxWorld(), size, defaultPosition, BodyDef.BodyType.DynamicBody, true);
        body.setUserData(this);
    }

    public abstract void setPosition(float x, float y);

    public String getInteractionHint() {
        return interactionHint;
    }

    public Body getBody() {
        return body;
    }
}
