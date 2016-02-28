package eu.janschupke.buddy.content.stage.level.house.obstacle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.framework.base.entity.Obstacle;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

/**
 * Table obstacle.
 *
 * @author jan.schupke@gmail.com
 */
public class TableObstacle extends Obstacle {
    public TableObstacle(BaseWorld world, Vector2 size) {
        super(world, new Texture(Gdx.files.internal("textures/levels/house/terrain/table.png")), size);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
    }

    @Override
    public void update(float delta) {

    }
}
