package eu.janschupke.buddy.content.stage.level.forest.unit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import eu.janschupke.buddy.content.stage.level.forest.ForestEventHandler;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.entity.Unit;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;
import eu.janschupke.buddy.framework.base.exception.NoHudException;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.world.BaseWorld;
import eu.janschupke.buddy.framework.util.Utility;

/**
 * Ukko unit class.
 */
public class UkkoUnit extends Unit implements Triggerable {
    public UkkoUnit(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/sprites/units/Character_Hero_Priest.png")));
        animationTexture = new Texture(Gdx.files.internal("textures/sprites/units/Character_Hero_Priest.png"));
        animationFrames = TextureRegion.split(animationTexture, 100, 100);
        initAnimations();
        initIdleSprites();
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.talk");
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

    @Override
    public void engage() {
        try {
            InteractionSwitch.enable(this,
                    ((ForestEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getUkkoTalkEvent(),
                    Utility.getHud(world.getScreen().getApp()).getHintTable());
        } catch (NoHudException e) {
            Gdx.app.log("UkkoUnit#engage", "No HUD problem.");
        }
    }

    @Override
    public void disengage() {
        try {
            InteractionSwitch.disable(Utility.getHud(world.getScreen().getApp()).getHintTable());
        } catch (NoHudException e) {
            Gdx.app.log("UkkoUnit#disengage", "No HUD problem.");
        }
    }
}
