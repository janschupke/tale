package eu.janschupke.tale.content.stage.level.cave.unit.corpsec;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import eu.janschupke.tale.content.stage.level.cave.CaveEventHandler;
import eu.janschupke.tale.content.stage.level.cave.unit.corpsec.interaction.CorpsecInteraction;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.entity.Unit;
import eu.janschupke.tale.framework.event.handling.InteractionSwitch;
import eu.janschupke.tale.framework.exception.NoHudException;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.screen.GameScreen;
import eu.janschupke.tale.framework.world.BaseWorld;

/**
 * Dead Corpsec unit.
 *
 * @author jan.schupke@gmail.com
 */
public class CorpsecUnit extends Unit implements Triggerable {
    private Interaction interaction;

    public CorpsecUnit(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/levels/cave/units/corpsec.png")));
        animationTexture = new Texture(Gdx.files.internal("textures/levels/cave/units/corpsec.png"));
        animationFrames = TextureRegion.split(animationTexture, 100, 100);
        initAnimations();
        initIdleSprites();
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.talk");
        interaction = new CorpsecInteraction(world.getScreen().getApp(), this);
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
        InteractionSwitch.enable(this,
                ((CaveEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getCorpsecInteractionEvent(),
                world.getScreen().getApp());
    }

    @Override
    public void disengage() {
        try {
            endInteraction(world.getScreen().getApp());
            InteractionSwitch.disable(world.getScreen().getApp().getHud().getHintTable());
        } catch (NoHudException e) {
            Gdx.app.log("CorpsecUnit#disengage", "Could not get HUD instance");
        }
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}
