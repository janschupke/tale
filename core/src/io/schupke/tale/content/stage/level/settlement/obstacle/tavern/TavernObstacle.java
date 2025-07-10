package io.schupke.tale.content.stage.level.settlement.obstacle.tavern;

import io.schupke.tale.base.entity.Obstacle;
import io.schupke.tale.base.entity.Triggerable;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.interaction.InteractionSwitch;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.base.world.BaseWorld;
import io.schupke.tale.content.stage.level.settlement.event.SettlementEventHandler;
import io.schupke.tale.content.stage.level.settlement.obstacle.tavern.interaction.TavernInteraction;

/**
 * Tavern building.
 *
 * @author jan.schupke@gmail.com
 */
public class TavernObstacle extends Obstacle implements Triggerable {
    private Interaction interaction;

    public TavernObstacle(BaseWorld world, int radius) {
        super(world, world.getScreen().getApp().getResourceManager().getTextureHandler().getSettlementTavernTexture(), radius);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        interaction = new TavernInteraction(world.getScreen().getApp(), this);
        sprite.flip(true, false);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((SettlementEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getTavernInteractionEvent(),
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
