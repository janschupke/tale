package eu.janschupke.buddy.content.stage.level.cave.sensor;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.content.stage.level.cave.CaveEventHandler;
import eu.janschupke.buddy.framework.base.entity.Sensor;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

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
