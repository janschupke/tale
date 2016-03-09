package eu.janschupke.tale.content.stage.level.settlement.sensor;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.content.stage.level.settlement.event.SettlementEventHandler;
import eu.janschupke.tale.framework.entity.Sensor;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.screen.GameScreen;
import eu.janschupke.tale.framework.world.BaseWorld;

/**
 * Exploration sensor for the Chobo's area.
 *
 * @author jan.schupke@gmail.com
 */
public class ChoboExplorationSensor extends Sensor implements Triggerable {
    public ChoboExplorationSensor(BaseWorld world, Vector2 size) {
        super(world, size);
    }

    @Override
    public void engage() {
        ((SettlementEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getChoboExplorationEvent().trigger();
    }

    @Override
    public void disengage() {

    }

    @Override
    public Interaction getInteraction() {
        return null;
    }
}
