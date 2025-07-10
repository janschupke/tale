package io.schupke.tale.content.stage.level.settlement.obstacle.fountain;

import io.schupke.tale.base.entity.Obstacle;
import io.schupke.tale.base.entity.Triggerable;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.interaction.InteractionSwitch;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.base.world.BaseWorld;
import io.schupke.tale.content.stage.level.settlement.event.SettlementEventHandler;
import io.schupke.tale.content.stage.level.settlement.obstacle.fountain.interaction.FountainInteraction;

/**
 * Fountain obstacle.
 *
 * @author jan.schupke@gmail.com
 */
public class FountainObstacle extends Obstacle implements Triggerable {
    private Interaction interaction;

    public FountainObstacle(BaseWorld world, int radius) {
        super(world, world.getScreen().getApp().getResourceManager().getTextureHandler().getSettlementFountainTexture(), radius);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        interaction = new FountainInteraction(world.getScreen().getApp(), this);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((SettlementEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getFountainInteractionEvent(),
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
