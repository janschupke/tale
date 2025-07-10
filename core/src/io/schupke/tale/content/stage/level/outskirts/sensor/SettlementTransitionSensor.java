package io.schupke.tale.content.stage.level.outskirts.sensor;

import com.badlogic.gdx.math.Vector2;
import io.schupke.tale.base.entity.Sensor;
import io.schupke.tale.base.entity.Triggerable;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.base.world.BaseWorld;
import io.schupke.tale.content.stage.level.outskirts.event.OutskirtsEventHandler;

/**
 * Sensor for transition from Outskirts to Settlement.
 *
 * @author jan.schupke@gmail.com
 */
public class SettlementTransitionSensor extends Sensor implements Triggerable {
    public SettlementTransitionSensor(BaseWorld world, Vector2 size) {
        super(world, size);
    }

    @Override
    public void engage() {
        ((OutskirtsEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getSettlementTransitionEvent().trigger();
    }

    @Override
    public void disengage() {
    }

    @Override
    public Interaction getInteraction() {
        return null;
    }
}
