package eu.janschupke.buddy.content.stage.level.forest.sensor;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.content.stage.level.forest.ForestEventHandler;
import eu.janschupke.buddy.framework.base.entity.Sensor;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

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
