package eu.janschupke.tale.content.stage.level.outskirts.sensor;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.content.stage.level.outskirts.OutskirtsEventHandler;
import eu.janschupke.tale.framework.base.entity.Sensor;
import eu.janschupke.tale.framework.base.entity.Triggerable;
import eu.janschupke.tale.framework.base.interaction.Interaction;
import eu.janschupke.tale.framework.base.screen.GameScreen;
import eu.janschupke.tale.framework.base.world.BaseWorld;

/**
 * Exploration sensor for the cave area.
 *
 * @author jan.schupke@gmail.com
 */
public class CaveExplorationSensor extends Sensor implements Triggerable {
    public CaveExplorationSensor(BaseWorld world, Vector2 size) {
        super(world, size);
    }

    @Override
    public void engage() {
        ((OutskirtsEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getCaveExplorationEvent().trigger();
    }

    @Override
    public void disengage() {

    }

    @Override
    public Interaction getInteraction() {
        return null;
    }
}
