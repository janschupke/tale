package eu.janschupke.buddy.content.stage.level.house.obstacle.cauldron;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.content.stage.level.house.HouseEventHandler;
import eu.janschupke.buddy.content.stage.level.house.obstacle.cauldron.interaction.CauldronInteraction;
import eu.janschupke.buddy.framework.base.entity.Obstacle;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;
import eu.janschupke.buddy.framework.base.exception.NoHudException;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

/**
 * Cauldron obstacle.
 *
 * @author jan.schupke@gmail.com
 */
public class CauldronObstacle extends Obstacle implements Triggerable {
    private Interaction interaction;

    public CauldronObstacle(BaseWorld world, Vector2 size) {
        super(world, new Texture(Gdx.files.internal("textures/levels/house/terrain/cauldron.png")), size);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        interaction = new CauldronInteraction(world.getScreen().getApp(), this);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((HouseEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getCauldronInteractionEvent(),
                world.getScreen().getApp());
    }

    @Override
    public void disengage() {
        try {
            endInteraction(world.getScreen().getApp());
            InteractionSwitch.disable(world.getScreen().getApp().getHud().getHintTable());
        } catch (NoHudException e) {
            Gdx.app.log("CauldronObstacle#disengage", "No HUD problem");
        }
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}
