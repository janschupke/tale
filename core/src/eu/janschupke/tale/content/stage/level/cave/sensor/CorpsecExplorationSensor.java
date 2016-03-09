package eu.janschupke.tale.content.stage.level.cave.sensor;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.content.stage.level.cave.event.CaveEventHandler;
import eu.janschupke.tale.framework.entity.Sensor;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.screen.GameScreen;
import eu.janschupke.tale.framework.world.BaseWorld;

/**
 * Sensor for the Corpsec area exploration.
 *
 * @author jan.schupke@gmail.com
 */
public class CorpsecExplorationSensor extends Sensor implements Triggerable {
    public CorpsecExplorationSensor(BaseWorld world, Vector2 size) {
        super(world, size);
    }

    @Override
    public void engage() {
        ((CaveEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getCorpsecExplorationEvent().trigger();
    }

    @Override
    public void disengage() {

    }

    @Override
    public Interaction getInteraction() {
        return null;
    }
}
