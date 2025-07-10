package io.schupke.tale.content.stage.level.forest.obstacle.caravan;

import io.schupke.tale.base.entity.Obstacle;
import io.schupke.tale.base.entity.Triggerable;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.interaction.InteractionSwitch;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.base.world.BaseWorld;
import io.schupke.tale.content.stage.level.forest.event.ForestEventHandler;
import io.schupke.tale.content.stage.level.forest.obstacle.caravan.interaction.CaravanInteraction;

/**
 * Caravan wreck world obstacle.
 *
 * @author jan.schupke@gmail.com
 */
public class CaravanObstacle extends Obstacle implements Triggerable {
    private Interaction interaction;

    public CaravanObstacle(BaseWorld world, int radius) {
        super(world, world.getScreen().getApp().getResourceManager().getTextureHandler().getCaravanObstacleTexture(), radius);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        interaction = new CaravanInteraction(world.getScreen().getApp(), this);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((ForestEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getCaravanInteractionEvent(),
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
