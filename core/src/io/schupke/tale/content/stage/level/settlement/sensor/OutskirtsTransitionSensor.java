package io.schupke.tale.content.stage.level.settlement.sensor;

import com.badlogic.gdx.math.Vector2;
import io.schupke.tale.base.entity.Sensor;
import io.schupke.tale.base.entity.Triggerable;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.base.world.BaseWorld;
import io.schupke.tale.content.stage.level.settlement.event.SettlementEventHandler;

/**
 * Transition sensor from Settlement to Outskirts.
 *
 * @author jan.schupke@gmail.com
 */
public class OutskirtsTransitionSensor extends Sensor implements Triggerable {
    public OutskirtsTransitionSensor(BaseWorld world, Vector2 size) {
        super(world, size);
    }

    @Override
    public void engage() {
        ((SettlementEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getOutskirtsTransitionEvent().trigger();
    }

    @Override
    public void disengage() {
    }

    @Override
    public Interaction getInteraction() {
        return null;
    }
}
