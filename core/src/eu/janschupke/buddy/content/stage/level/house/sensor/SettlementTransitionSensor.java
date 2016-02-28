package eu.janschupke.buddy.content.stage.level.house.sensor;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.framework.base.entity.Sensor;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

/**
 * Transition sensor from House to Settlement.
 *
 * @author jan.schupke@gmail.com
 */
public class SettlementTransitionSensor extends Sensor implements Triggerable {
    public SettlementTransitionSensor(BaseWorld world, Vector2 size) {
        super(world, size);
    }

    @Override
    public void engage() {

    }

    @Override
    public void disengage() {

    }

    @Override
    public Interaction getInteraction() {
        return null;
    }
}
