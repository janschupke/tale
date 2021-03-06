package eu.janschupke.tale.content.stage.level.settlement.obstacle;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.base.entity.Triggerable;
import eu.janschupke.tale.base.entity.Wall;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.world.BaseWorld;

/**
 * A wall obstacle that prevents passing through transition sensor.
 *
 * @author jan.schupke@gmail.com
 */
public class OutskirtsTransitionWall extends Wall implements Triggerable {
    public OutskirtsTransitionWall(BaseWorld world, Vector2 size) {
        super(world, size);
    }

    @Override
    public void engage() {

    }

    @Override
    public void disengage() {

    }

    @Override
    public Interaction getInteraction() {
        return null;
    }
}
