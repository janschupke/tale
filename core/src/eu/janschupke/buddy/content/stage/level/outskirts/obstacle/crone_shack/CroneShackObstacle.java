package eu.janschupke.buddy.content.stage.level.outskirts.obstacle.crone_shack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.content.stage.level.outskirts.OutskirtsEventHandler;
import eu.janschupke.buddy.content.stage.level.outskirts.obstacle.crone_shack.interaction.CroneShackInteraction;
import eu.janschupke.buddy.framework.base.entity.Obstacle;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;
import eu.janschupke.buddy.framework.base.exception.NoHudException;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

/**
 * Crone shack obstacle object.
 *
 * @author jan.schupke@gmail.com
 */
public class CroneShackObstacle extends Obstacle implements Triggerable {
    private Interaction interaction;

    public CroneShackObstacle(BaseWorld world,  Vector2 size) {
        super(world, new Texture(Gdx.files.internal("textures/levels/outskirts/terrain/crone-shack.png")), size);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        interaction = new CroneShackInteraction(world.getScreen().getApp(), this);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((OutskirtsEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getCroneShackInteractionEvent(),
                world.getScreen().getApp());
    }

    @Override
    public void disengage() {
        try {
            endInteraction(world.getScreen().getApp());
            InteractionSwitch.disable(world.getScreen().getApp().getHud().getHintTable());
        } catch (NoHudException e) {
            Gdx.app.log("CroneShackObstacle#disengage", "Could not get HUD instance");
        }
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}
