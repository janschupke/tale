package eu.janschupke.tale.content.stage.level.outskirts.sensor;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.content.stage.level.outskirts.event.OutskirtsEventHandler;
import eu.janschupke.tale.framework.entity.Sensor;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.screen.GameScreen;
import eu.janschupke.tale.framework.world.BaseWorld;

/**
 * Exploration sensor for the Jack area.
 *
 * @author jan.schupke@gmail.com
 */
public class JackExplorationSensor extends Sensor implements Triggerable {
    public JackExplorationSensor(BaseWorld world, Vector2 size) {
        super(world, size);
    }

    @Override
    public void engage() {
        ((OutskirtsEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getJackExplorationEvent().trigger();
    }

    @Override
    public void disengage() {

    }

    @Override
    public Interaction getInteraction() {
        return null;
    }
}
