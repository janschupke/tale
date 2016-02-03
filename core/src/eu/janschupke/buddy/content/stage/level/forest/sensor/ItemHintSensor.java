package eu.janschupke.buddy.content.stage.level.forest.sensor;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.content.stage.level.forest.ForestEventHandler;
import eu.janschupke.buddy.framework.base.entity.Interactible;
import eu.janschupke.buddy.framework.base.entity.Sensor;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

/**
 * Sensor that triggers item introduction event.
 */
public class ItemHintSensor extends Sensor implements Interactible {
    public ItemHintSensor(BaseWorld world, Vector2 size) {
        super(world, size);
    }

    @Override
    public void engage() {
        ((ForestEventHandler)((GameScreen)world.getScreen()).getLevelEventHandler()).getItemHintEvent().trigger();
    }

    @Override
    public void disengage() {

    }
}
