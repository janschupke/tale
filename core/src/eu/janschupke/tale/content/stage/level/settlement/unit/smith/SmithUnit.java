package eu.janschupke.tale.content.stage.level.settlement.unit.smith;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import eu.janschupke.tale.base.entity.Triggerable;
import eu.janschupke.tale.base.entity.Unit;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.interaction.InteractionSwitch;
import eu.janschupke.tale.base.screen.GameScreen;
import eu.janschupke.tale.base.world.BaseWorld;
import eu.janschupke.tale.content.stage.level.settlement.event.SettlementEventHandler;
import eu.janschupke.tale.content.stage.level.settlement.unit.smith.interaction.SmithInteraction;

/**
 * Smith unit.
 *
 * @author jan.schupke@gmail.com
 */
public class SmithUnit extends Unit implements Triggerable {
    private Interaction interaction;

    public SmithUnit(BaseWorld world) {
        super(world, world.getScreen().getApp().getResourceManager().getTextureHandler().getSettlementSmithTexture());
        animationTexture = world.getScreen().getApp().getResourceManager().getTextureHandler().getSettlementSmithTexture();
        animationFrames = TextureRegion.split(animationTexture, 100, 100);
        initAnimations();
        initIdleSprites();
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.talk");
        interaction = new SmithInteraction(world.getScreen().getApp(), this);
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
                ((SettlementEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getSmithInteractionEvent(),
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
