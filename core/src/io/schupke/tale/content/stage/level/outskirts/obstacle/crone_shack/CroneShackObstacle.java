package io.schupke.tale.content.stage.level.outskirts.obstacle.crone_shack;

import com.badlogic.gdx.math.Vector2;
import io.schupke.tale.base.entity.Obstacle;
import io.schupke.tale.base.entity.Triggerable;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.interaction.InteractionSwitch;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.base.world.BaseWorld;
import io.schupke.tale.content.stage.level.outskirts.event.OutskirtsEventHandler;
import io.schupke.tale.content.stage.level.outskirts.obstacle.crone_shack.interaction.CroneShackInteraction;

/**
 * Crone shack obstacle object.
 *
 * @author jan.schupke@gmail.com
 */
public class CroneShackObstacle extends Obstacle implements Triggerable {
    private Interaction interaction;

    public CroneShackObstacle(BaseWorld world, Vector2 size) {
        super(world, world.getScreen().getApp().getResourceManager().getTextureHandler().getOutskirtsCroneShackTexture(), size);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        interaction = new CroneShackInteraction(world.getScreen().getApp(), this);
        sprite.flip(true, false);
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
        endInteraction(world.getScreen().getApp());
        InteractionSwitch.disable(world.getScreen().getApp());
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}
