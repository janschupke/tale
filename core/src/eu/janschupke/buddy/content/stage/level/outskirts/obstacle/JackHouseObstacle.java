package eu.janschupke.buddy.content.stage.level.outskirts.obstacle;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.framework.base.entity.Obstacle;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

/**
 * Jack's house obstacle object.
 *
 * @author jan.schupke@gmail.com
 */
public class JackHouseObstacle extends Obstacle implements Triggerable {
    public JackHouseObstacle(BaseWorld world, Vector2 size) {
        super(world, null, size);
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

    @Override
    public void update(float delta) {

    }
}
