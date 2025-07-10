package io.schupke.tale.content.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef;
import io.schupke.tale.base.entity.Unit;
import io.schupke.tale.base.world.BaseWorld;

/**
 * Player unit class.
 */
public class PlayerUnit extends Unit {
    public PlayerUnit(BaseWorld world) {
        super(world, world.getScreen().getApp().getResourceManager().getTextureHandler().getPlayerTexture());
        animationTexture = world.getScreen().getApp().getResourceManager().getTextureHandler().getPlayerTexture();
        animationFrames = TextureRegion.split(animationTexture, 100, 100);
        initAnimations();
        initIdleSprites();

        body.setType(BodyDef.BodyType.DynamicBody);
    }

    @Override
    protected void initIdleSprites() {
        Texture t = sprite.getTexture();
        idleTextures.put(Direction.UP, new TextureRegion(t, 0, 100, 100, 100));
        idleTextures.put(Direction.DOWN, new TextureRegion(t, 0, 200, 100, 100));
        TextureRegion tr = new TextureRegion(t, 0, 0, 100, 100);
        tr.flip(true, false);
        idleTextures.put(Direction.RIGHT, tr);
        idleTextures.put(Direction.LEFT, new TextureRegion(t, 0, 0, 100, 100));
    }
}
