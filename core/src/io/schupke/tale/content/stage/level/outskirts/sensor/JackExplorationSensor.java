package io.schupke.tale.content.stage.level.outskirts.sensor;

import com.badlogic.gdx.math.Vector2;
import io.schupke.tale.base.entity.Sensor;
import io.schupke.tale.base.entity.Triggerable;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.base.world.BaseWorld;
import io.schupke.tale.content.stage.level.outskirts.event.OutskirtsEventHandler;

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
