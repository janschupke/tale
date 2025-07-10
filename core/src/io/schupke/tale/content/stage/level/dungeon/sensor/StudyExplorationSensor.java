package io.schupke.tale.content.stage.level.dungeon.sensor;

import com.badlogic.gdx.math.Vector2;
import io.schupke.tale.base.entity.Sensor;
import io.schupke.tale.base.entity.Triggerable;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.base.world.BaseWorld;
import io.schupke.tale.content.stage.level.dungeon.event.DungeonEventHandler;

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
