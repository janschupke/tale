package eu.janschupke.buddy.content.stage.level.dungeon.obstacle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.framework.base.entity.Obstacle;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

/**
 * Dungeon study table.
 *
 * @author jan.schupke@gmail.com
 */
public class TableObstacle extends Obstacle {
    public TableObstacle(BaseWorld world, Vector2 size) {
        super(world, new Texture(Gdx.files.internal("textures/levels/dungeon/terrain/table.png")), size);
    }

    @Override
    public void update(float delta) {

    }
}
