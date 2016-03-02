package eu.janschupke.tale.content.stage.level.house.sensor;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.content.stage.level.house.HouseEventHandler;
import eu.janschupke.tale.framework.base.entity.Sensor;
import eu.janschupke.tale.framework.base.entity.Triggerable;
import eu.janschupke.tale.framework.base.interaction.Interaction;
import eu.janschupke.tale.framework.base.screen.GameScreen;
import eu.janschupke.tale.framework.base.world.BaseWorld;

/**
 * Exploration sensor for the part of the room.
 *
 * @author jan.schupke@gmail.com
 */
public class RoomExplorationSensor extends Sensor implements Triggerable {
    public RoomExplorationSensor(BaseWorld world, Vector2 size) {
        super(world, size);
    }

    @Override
    public void engage() {
        ((HouseEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getRoomExplorationEvent().trigger();
    }

    @Override
    public void disengage() {

    }

    @Override
    public Interaction getInteraction() {
        return null;
    }
}
