package eu.janschupke.buddy.content.entity.obstacle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.framework.base.entity.Obstacle;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

/**
 * Cave entrance world obstacle.
 */
public class Cave extends Obstacle {
    public Cave(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/terrain/cave_entrance.png")), new Vector2(3, 3));
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
