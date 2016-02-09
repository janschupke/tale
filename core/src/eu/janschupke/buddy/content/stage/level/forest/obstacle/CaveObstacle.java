package eu.janschupke.buddy.content.stage.level.forest.obstacle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.framework.base.entity.Obstacle;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

/**
 * Cave entrance world obstacle.
 */
public class CaveObstacle extends Obstacle implements Triggerable {
    public CaveObstacle(BaseWorld world, Vector2 size) {
        super(world, new Texture(Gdx.files.internal("textures/terrain/cave_entrance.png")), size);
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
}
