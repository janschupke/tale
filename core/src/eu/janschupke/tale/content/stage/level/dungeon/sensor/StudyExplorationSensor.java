package eu.janschupke.tale.content.stage.level.dungeon.sensor;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.content.stage.level.dungeon.event.DungeonEventHandler;
import eu.janschupke.tale.framework.entity.Sensor;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.screen.GameScreen;
import eu.janschupke.tale.framework.world.BaseWorld;

/**
 * Exploration sensor for the dungeon study area.
 *
 * @author jan.schupke@gmail.com
 */
public class StudyExplorationSensor extends Sensor implements Triggerable {
    public StudyExplorationSensor(BaseWorld world, Vector2 size) {
        super(world, size);
    }

    @Override
    public void engage() {
        ((DungeonEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getStudyExplorationEvent().trigger();
    }

    @Override
    public void disengage() {

    }

    @Override
    public Interaction getInteraction() {
        return null;
    }
}
