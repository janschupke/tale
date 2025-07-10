package io.schupke.tale.content.stage.level.forest.sensor;

import com.badlogic.gdx.math.Vector2;
import io.schupke.tale.base.entity.Sensor;
import io.schupke.tale.base.entity.Triggerable;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.base.world.BaseWorld;
import io.schupke.tale.content.stage.level.forest.event.ForestEventHandler;

/**
 * Sensor that triggers unit interaction introduction.
 *
 * @author jan.schupke@gmail.com
 */
public class UnitIntroSensor extends Sensor implements Triggerable {
    public UnitIntroSensor(BaseWorld world, Vector2 size) {
        super(world, size);
    }

    @Override
    public void engage() {
        ((ForestEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getUnitIntroGeneralEvent().trigger();
    }

    @Override
    public void disengage() {

    }

    @Override
    public Interaction getInteraction() {
        return null;
    }
}
