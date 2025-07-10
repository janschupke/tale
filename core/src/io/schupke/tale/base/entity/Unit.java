package io.schupke.tale.base.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import io.schupke.tale.base.utility.WorldObjectFactory;
import io.schupke.tale.base.world.BaseWorld;
import io.schupke.tale.content.config.Config;
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

    protected final float defaultAcceleration = Config.OBJECT_ACCELERATION;
    protected final float maxSpeed = Config.OBJECT_MAX_SPEED;
    protected boolean movingRight;
    protected boolean movingLeft;
    protected boolean movingUp;
    protected boolean movingDown;
    protected boolean climbingUp;
    protected boolean climbingDown;
    protected Direction lastDirection;
    protected Texture animationTexture;
    protected TextureRegion[][] animationFrames;
    protected AnimatedBox2DSprite animatedBoxSpriteUp;
    protected AnimatedBox2DSprite animatedBoxSpriteDown;
    protected AnimatedBox2DSprite animatedBoxSpriteRight;
    protected AnimatedBox2DSprite animatedBoxSpriteLeft;
    protected Map<Direction, TextureRegion> idleTextures;
    protected int frameAmount = 6;
    protected float loopDuration = 2.0f;
    protected boolean animated;

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
     * Creates directional sprites for movement animations.
     */
    protected void initAnimations() {
        animated = true;
        animatedBoxSpriteUp = initAnimation(animationFrames[1]);
        animatedBoxSpriteDown = initAnimation(animationFrames[2]);

        // Create right-facing animation by flipping left-facing frames horizontally
        TextureRegion[] animationFramesRight = new TextureRegion[6];
        for (int i = 0; i < 6; i++) {
            // Deep copy before flipping to avoid modifying original frames
            animationFramesRight[i] = new TextureRegion(animationFrames[0][i]);
            animationFramesRight[i].flip(true, false);
        }

        animatedBoxSpriteRight = initAnimation(animationFramesRight);
        animatedBoxSpriteLeft = initAnimation(animationFrames[0]);
    }

    /**
     * Preserves required unit movement during screen transitions.
     *
     * @param previousScreenUnit Unit instance from the previous screen.
     */
    public void preserveMovement(Unit previousScreenUnit) {
        stop();
        if (previousScreenUnit.isMovingUp()) moveUp();
        if (previousScreenUnit.isMovingDown()) moveDown();
        if (previousScreenUnit.isMovingRight()) moveRight();
        if (previousScreenUnit.isMovingLeft()) moveLeft();
    }

    /**
     * Generic animation initialization.
     *
     * @param frames Array of frames.
     * @return Resulting animated Box2D sprite.
     */
    private AnimatedBox2DSprite initAnimation(TextureRegion[] frames) {
        Animation regionAnimation = new Animation(1.0f / (frameAmount / loopDuration), frames);
        regionAnimation.setPlayMode(Animation.PlayMode.LOOP);
        AnimatedSprite animatedSprite = new AnimatedSprite(regionAnimation);
        return new AnimatedBox2DSprite(animatedSprite);
    }

    /**
     * Updates unit's position based on its movement state.
     *
     * @param delta Elapsed time since last render.
     */
    @Override
    public void update(float delta) {
        if (movingLeft) moveLeft();
        if (movingRight) moveRight();
        if (movingUp) moveUp();
        if (movingDown) moveDown();
        if (climbingUp) climbUp();
        if (climbingDown) climbDown();
    }

    @Override
    public void draw(Batch batch) {
        if (!animated) {
            sprite.draw(batch, body);
            return;
        }

        // Draw appropriate animated sprite based on movement direction
        if (movingUp && animatedBoxSpriteUp != null) {
            animatedBoxSpriteUp.draw(batch, body);
        } else if (movingDown && animatedBoxSpriteDown != null) {
            animatedBoxSpriteDown.draw(batch, body);
        } else if (movingRight && animatedBoxSpriteRight != null) {
            animatedBoxSpriteRight.draw(batch, body);
        } else if (movingLeft && animatedBoxSpriteLeft != null) {
            animatedBoxSpriteLeft.draw(batch, body);
        } else {
            // Not moving, draw idle sprite facing the last movement direction
            sprite.setRegion(idleTextures.get(lastDirection));
            sprite.draw(batch, body);
        }
    }

    /**
     * Not implemented for the purpose of this game.
     * Platforming is not utilized.
     */
    public void jump() {
    }

    /**
     * Calculates unit's upward movement.
     */
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

    /**
     * Calculates unit's downward movement.
     */
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

    /**
     * Calculates unit's right movement.
     */
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

    /**
     * Calculates unit's left movement.
     */
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

    /**
     * Stops all movements of this unit.
     */
    public void stop() {
        stopUp();
        stopDown();
        stopRight();
        stopLeft();
    }

    @Override
    public void dispose() {
        super.dispose();

        try {
            animationTexture.dispose();
            animatedBoxSpriteUp.getTexture().dispose();
            animatedBoxSpriteDown.getTexture().dispose();
            animatedBoxSpriteRight.getTexture().dispose();
            animatedBoxSpriteLeft.getTexture().dispose();
        } catch (NullPointerException e) {
            Gdx.app.log("Unit#dispose", "Null texture");
        }
    }

    public boolean isMovingUp() {
        return movingUp;
    }

    public boolean isMovingDown() {
        return movingDown;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public boolean isMovingLeft() {
        return movingLeft;
    }
}
