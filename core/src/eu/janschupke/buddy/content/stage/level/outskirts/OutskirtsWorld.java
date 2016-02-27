package eu.janschupke.buddy.content.stage.level.outskirts;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.content.entity.PlayerUnit;
import eu.janschupke.buddy.content.stage.level.outskirts.obstacle.CaveObstacle;
import eu.janschupke.buddy.framework.base.entity.Obstacle;
import eu.janschupke.buddy.framework.base.world.TopDownWorld;

/**
 * Outskirts (Level 1) world.
 *
 * @author jan.schupke@gmail.com
 */
public class OutskirtsWorld extends TopDownWorld {
    public OutskirtsWorld(OutskirtsScreen screen) {
        super("maps/outskirts.tmx", 32f, screen);
    }

    @Override
    protected void initPlayer() {
        setSpawnPoint(5, 5);
        setPlayerUnit(new PlayerUnit(this));
        positionPlayerUnit();
    }

    @Override
    protected void initCreatures() {

    }

    @Override
    protected void initItems() {

    }

    @Override
    protected void initObstacles() {
        Obstacle caveObstacle = new CaveObstacle(this, new Vector2(3, 3));
        caveObstacle.setPosition(23, 22);
        getObstacles().add(caveObstacle);
    }

    @Override
    protected void initEffects() {
    }

    @Override
    protected void initSensors() {

    }
}
