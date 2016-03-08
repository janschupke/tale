package eu.janschupke.tale.content.stage.level.forest.unit.ukko;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import eu.janschupke.tale.content.stage.level.forest.ForestEventHandler;
import eu.janschupke.tale.content.stage.level.forest.unit.ukko.interaction.UkkoInteraction;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.entity.Unit;
import eu.janschupke.tale.framework.exception.NoHudException;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.interaction.InteractionSwitch;
import eu.janschupke.tale.framework.screen.GameScreen;
import eu.janschupke.tale.framework.world.BaseWorld;

/**
 * Ukko unit class.
 *
 * @author jan.schupke@gmail.com
 */
public class UkkoUnit extends Unit implements Triggerable {
    private Interaction interaction;

    public UkkoUnit(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/levels/forest/units/ukko.png")));
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.talk");
        interaction = new UkkoInteraction(world.getScreen().getApp(), this);
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
                ((ForestEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getUkkoInteractionEvent(),
                world.getScreen().getApp());
    }

    @Override
    public void disengage() {
        try {
            endInteraction(world.getScreen().getApp());
            InteractionSwitch.disable(world.getScreen().getApp().getHud().getHintTable());
        } catch (NoHudException e) {
            Gdx.app.log("UkkoUnit#disengage", "Could not get HUD instance");
        }
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}
