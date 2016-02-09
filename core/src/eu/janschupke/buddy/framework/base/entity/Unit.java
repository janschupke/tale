package eu.janschupke.buddy.framework.base.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import eu.janschupke.buddy.framework.base.world.BaseWorld;
import eu.janschupke.buddy.framework.config.Config;
import eu.janschupke.buddy.framework.util.WorldObjectFactory;
import net.dermetfan.gdx.graphics.g2d.AnimatedBox2DSprite;
import net.dermetfan.gdx.graphics.g2d.AnimatedSprite;

import java.util.HashMap;
import java.util.Map;

/**
 * Base class for all in-game units.
 */
public abstract class Unit extends WorldObject {
    protected enum Direction {
        UP, DOWN, RIGHT, LEFT
    }

    protected boolean movingRight;
    protected boolean movingLeft;
    protected boolean movingUp;
    protected boolean movingDown;
    protected boolean climbingUp;
    protected boolean climbingDown;

    protected Direction lastDirection;

    protected final float defaultAcceleration = Config.OBJECT_ACCELERATION;
    protected final float maxSpeed = Config.OBJECT_MAX_SPEED;

    protected Texture animationTexture;
    protected TextureRegion[][] animationFrames;

    protected AnimatedBox2DSprite animatedBoxSpriteUp;
    protected AnimatedBox2DSprite animatedBoxSpriteDown;
    protected AnimatedBox2DSprite animatedBoxSpriteRight;
    protected AnimatedBox2DSprite animatedBoxSpriteLeft;

    protected Map<Direction, TextureRegion> idleTextures;

    protected int frameAmount = 6;
    protected float loopDuration = 2.0f;

    public Unit(BaseWorld world, Texture texture, Vector2 size) {
        super(world, texture, size);

        lastDirection = Direction.DOWN;
        idleTextures = new HashMap<>();
        WorldObjectFactory.setCollisions(body, Config.BIT_UNIT_ANY, (short) (Config.BIT_OBSTACLE_ANY | Config.BIT_UNIT_ANY));
        body.setType(BodyDef.BodyType.KinematicBody);
    }

    public Unit(BaseWorld world, Texture texture) {
        this(world, texture, Config.DEFAULT_UNIT_SIZE);
    }

    /**
     * Instantiates texture region for directional idle sprites.
     */
    protected abstract void initIdleSprites();

    /**
     * Initiates all required animation instances from the texture.
     */
    protected void initAnimations() {
        animatedBoxSpriteUp = initAnimation(animationFrames[1]);
        animatedBoxSpriteDown = initAnimation(animationFrames[2]);

        TextureRegion[] animationFramesRight = new TextureRegion[6];
        for (int i = 0; i < 6; i++) {
            // Deep copy before flipping.
            animationFramesRight[i] = new TextureRegion(animationFrames[0][i]);
            animationFramesRight[i].flip(true, false);
        }

        animatedBoxSpriteRight = initAnimation(animationFramesRight);
        animatedBoxSpriteLeft = initAnimation(animationFrames[0]);
    }

    /**
     * Generic animation initialization.
     * @param frames Array of frames.
     * @return Resulting animated Box2D sprite.
     */
    private AnimatedBox2DSprite initAnimation(TextureRegion[] frames) {
        Animation regionAnimation = new Animation(1.0f / (frameAmount / loopDuration), frames);
        regionAnimation.setPlayMode(Animation.PlayMode.LOOP);
        AnimatedSprite animatedSprite = new AnimatedSprite(regionAnimation);
        return new AnimatedBox2DSprite(animatedSprite);
    }

    @Override
    public void update(float delta) {
        if (movingLeft)  moveLeft();
        if (movingRight) moveRight();
        if (movingUp) moveUp();
        if (movingDown) moveDown();
        if (climbingUp) climbUp();
        if (climbingDown) climbDown();
    }

    @Override
    public void draw(Batch batch) {
        if(movingUp && animatedBoxSpriteUp != null) {
            animatedBoxSpriteUp.draw(batch, body);
        } else if (movingDown && animatedBoxSpriteDown != null) {
            animatedBoxSpriteDown.draw(batch, body);
        } else if (movingRight && animatedBoxSpriteRight != null) {
            animatedBoxSpriteRight.draw(batch, body);
        } else if (movingLeft && animatedBoxSpriteLeft != null) {
            animatedBoxSpriteLeft.draw(batch, body);
        } else {
            sprite.setRegion(idleTextures.get(lastDirection));
            sprite.draw(batch, body);
        }
    }

    public void jump() {}

    public void moveUp() {
        movingUp = true;
        lastDirection = Direction.UP;
        Vector2 velocity = body.getLinearVelocity();
        velocity.y += defaultAcceleration;
        if (velocity.y > maxSpeed) {
            velocity.y = maxSpeed;
        }
        body.setLinearVelocity(velocity);
    }

    public void moveDown() {
        movingDown = true;
        lastDirection = Direction.DOWN;
        Vector2 velocity = body.getLinearVelocity();
        velocity.y -= defaultAcceleration;
        if (velocity.y < -maxSpeed) {
            velocity.y = -maxSpeed;
        }
        body.setLinearVelocity(velocity);
    }

    public void moveRight() {
        movingRight = true;
        lastDirection = Direction.RIGHT;
        Vector2 velocity = body.getLinearVelocity();
        velocity.x += defaultAcceleration;
        if (velocity.x > maxSpeed) {
            velocity.x = maxSpeed;
        }
        body.setLinearVelocity(velocity);
    }

    public void moveLeft() {
        movingLeft = true;
        lastDirection = Direction.LEFT;
        Vector2 velocity = body.getLinearVelocity();
        velocity.x -= defaultAcceleration;
        if (velocity.x < -maxSpeed) {
            velocity.x = -maxSpeed;
        }
        body.setLinearVelocity(velocity);
    }

    public void climbUp() {
        climbingUp = true;
    }

    public void climbDown() {
        climbingDown = true;
    }

    public void stopLeft() {
        movingLeft = false;
    }

    public void stopRight() {
        movingRight = false;
    }

    public void stopUp() {
        climbingUp = false;
        movingUp = false;
    }

    public void stopDown() {
        climbingDown = false;
        movingDown = false;
    }

    public void stop() {
        stopUp();
        stopDown();
        stopRight();
        stopLeft();
    }

    @Override
    public void dispose() {
        super.dispose();

        animationTexture.dispose();

        for (TextureRegion[] regions : animationFrames) {
            for (TextureRegion region : regions) {
                if (region.getTexture() != null) {
                    region.getTexture().dispose();
                }
            }
        }

        if (animatedBoxSpriteUp.getTexture() != null) {
            animatedBoxSpriteUp.getTexture().dispose();
        }
        if (animatedBoxSpriteDown.getTexture() != null) {
            animatedBoxSpriteDown.getTexture().dispose();
        }
        if (animatedBoxSpriteRight.getTexture() != null) {
            animatedBoxSpriteRight.getTexture().dispose();
        }
        if (animatedBoxSpriteLeft.getTexture() != null) {
            animatedBoxSpriteLeft.getTexture().dispose();
        }

        for (Map.Entry<Direction, TextureRegion> entry : idleTextures.entrySet()) {
            if (entry.getValue().getTexture() != null) {
                entry.getValue().getTexture().dispose();
            }
        }
    }
}
