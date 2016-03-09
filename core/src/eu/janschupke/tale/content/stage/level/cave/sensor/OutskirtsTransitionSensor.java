package eu.janschupke.tale.content.stage.level.cave.sensor;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.content.stage.level.cave.event.CaveEventHandler;
import eu.janschupke.tale.framework.entity.Sensor;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.screen.GameScreen;
import eu.janschupke.tale.framework.world.BaseWorld;

/**
 * Sensor for the transition from Cave to Outskirts.
 *
 * @author jan.schupke@gmail.com
 */
public class OutskirtsTransitionSensor extends Sensor implements Triggerable {
    public OutskirtsTransitionSensor(BaseWorld world, Vector2 size) {
        super(world, size);
    }

    @Override
    public void engage() {
        ((CaveEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getOutskirtsTransitionEvent().trigger();
    }

    @Override
    public void disengage() {

    }

    @Override
    public Interaction getInteraction() {
        return null;
    }
}
