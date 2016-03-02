package eu.janschupke.tale.content.stage.level.house.obstacle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.framework.entity.Obstacle;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.world.BaseWorld;

/**
 * Table obstacle.
 *
 * @author jan.schupke@gmail.com
 */
public class TableObstacle extends Obstacle implements Triggerable {
    public TableObstacle(BaseWorld world, Vector2 size) {
        super(world, new Texture(Gdx.files.internal("textures/levels/house/terrain/table.png")), size);
    }

    @Override
    public void update(float delta) {

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
