package eu.janschupke.tale.content.stage.level.cave.unit.corpsec;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.base.entity.Triggerable;
import eu.janschupke.tale.base.entity.Unit;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.interaction.InteractionSwitch;
import eu.janschupke.tale.base.screen.GameScreen;
import eu.janschupke.tale.base.world.BaseWorld;
import eu.janschupke.tale.content.stage.level.cave.event.CaveEventHandler;
import eu.janschupke.tale.content.stage.level.cave.unit.corpsec.interaction.CorpsecInteraction;

/**
 * Dead Corpsec unit.
 *
 * @author jan.schupke@gmail.com
 */
public class CorpsecUnit extends Unit implements Triggerable {
    private Interaction interaction;

    public CorpsecUnit(BaseWorld world) {
        super(world, world.getScreen().getApp().getResourceManager().getTextureHandler().getCaveCorpsecUnitTexture(),
                new Vector2(1.0f, 0.8f));
        body.setTransform(body.getPosition(), -0.3f);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.interact");
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
        endInteraction(world.getScreen().getApp());
        InteractionSwitch.disable(world.getScreen().getApp());
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}
