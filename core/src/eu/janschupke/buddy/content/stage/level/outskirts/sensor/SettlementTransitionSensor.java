package eu.janschupke.buddy.content.stage.level.outskirts.sensor;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.content.stage.level.outskirts.OutskirtsEventHandler;
import eu.janschupke.buddy.framework.base.entity.Sensor;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

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