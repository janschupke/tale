package io.schupke.tale.content.stage.level.forest.sensor;

import com.badlogic.gdx.math.Vector2;
import io.schupke.tale.base.entity.Sensor;
import io.schupke.tale.base.entity.Triggerable;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.base.world.BaseWorld;
import io.schupke.tale.content.stage.level.forest.event.ForestEventHandler;

/**
 * Exploration sensor for the south optional area.
 *
 * @author jan.schupke@gmail.com
 */
public class SouthExplorationSensor extends Sensor implements Triggerable {
    public SouthExplorationSensor(BaseWorld world, Vector2 size) {
        super(world, size);
    }

    @Override
    public void engage() {
        ((ForestEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getSouthExplorationEvent().trigger();
    }

    @Override
    public void disengage() {

    }

    @Override
    public Interaction getInteraction() {
        return null;
    }
}
