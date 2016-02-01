package eu.janschupke.buddy.content.stage.level.forest.unit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import eu.janschupke.buddy.framework.base.entity.Unit;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

/**
 * Ukko unit class.
 */
public class UkkoUnit extends Unit {
    public UkkoUnit(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/sprites/units/Character_Hero_Priest.png")));
        animationTexture = new Texture(Gdx.files.internal("textures/sprites/units/Character_Hero_Priest.png"));
        animationFrames = TextureRegion.split(animationTexture, 100, 100);
        initAnimations();
        initIdleSprites();
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
