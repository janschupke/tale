package eu.janschupke.buddy.content.stage.level.outskirts.sensor;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.content.stage.level.outskirts.OutskirtsEventHandler;
import eu.janschupke.buddy.framework.base.entity.Sensor;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

/**
 * Exploration sensor for the Varpunen note item.
 *
 * @author jan.schupke@gmail.com
 */
public class VarpunenExplorationSensor extends Sensor implements Triggerable {
    public VarpunenExplorationSensor(BaseWorld world, Vector2 size) {
        super(world, size);
    }

    @Override
    public void engage() {
        ((OutskirtsEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getVarpunenExplorationEvent().trigger();
    }

    @Override
    public void disengage() {

    }

    @Override
    public Interaction getInteraction() {
        return null;
    }
}
