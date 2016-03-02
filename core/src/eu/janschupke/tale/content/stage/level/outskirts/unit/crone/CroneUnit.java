package eu.janschupke.tale.content.stage.level.outskirts.unit.crone;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import eu.janschupke.tale.content.stage.level.outskirts.OutskirtsEventHandler;
import eu.janschupke.tale.content.stage.level.outskirts.unit.crone.interaction.CroneInteraction;
import eu.janschupke.tale.framework.base.entity.Triggerable;
import eu.janschupke.tale.framework.base.entity.Unit;
import eu.janschupke.tale.framework.base.event.handling.InteractionSwitch;
import eu.janschupke.tale.framework.base.exception.NoHudException;
import eu.janschupke.tale.framework.base.interaction.Interaction;
import eu.janschupke.tale.framework.base.screen.GameScreen;
import eu.janschupke.tale.framework.base.world.BaseWorld;

/**
 * Crone unit object.
 *
 * @author jan.schupke@gmail.com
 */
public class CroneUnit extends Unit implements Triggerable {
    private Interaction interaction;

    public CroneUnit(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/levels/outskirts/units/crone.png")));
        animationTexture = new Texture(Gdx.files.internal("textures/levels/outskirts/units/crone.png"));
        animationFrames = TextureRegion.split(animationTexture, 100, 100);
        initAnimations();
        initIdleSprites();
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.talk");
        interaction = new CroneInteraction(world.getScreen().getApp(), this);
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
                ((OutskirtsEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getCroneInteractionEvent(),
                world.getScreen().getApp());
    }

    @Override
    public void disengage() {
        try {
            endInteraction(world.getScreen().getApp());
            InteractionSwitch.disable(world.getScreen().getApp().getHud().getHintTable());
        } catch (NoHudException e) {
            Gdx.app.log("CroneUnit#disengage", "Could not get HUD instance");
        }
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}
