package eu.janschupke.tale.content.stage.level.settlement.obstacle.tavern;

import eu.janschupke.tale.base.entity.Obstacle;
import eu.janschupke.tale.base.entity.Triggerable;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.interaction.InteractionSwitch;
import eu.janschupke.tale.base.screen.GameScreen;
import eu.janschupke.tale.base.world.BaseWorld;
import eu.janschupke.tale.content.stage.level.settlement.event.SettlementEventHandler;
import eu.janschupke.tale.content.stage.level.settlement.obstacle.tavern.interaction.TavernInteraction;

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
