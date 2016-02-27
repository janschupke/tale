package eu.janschupke.buddy.content.stage.level.house;

import eu.janschupke.buddy.content.entity.PlayerUnit;
import eu.janschupke.buddy.framework.base.world.TopDownWorld;

/**
 * World for the house level.
 *
 * @author jan.schupke@gmail.com
 */
public class HouseWorld extends TopDownWorld {
    public HouseWorld(HouseScreen screen) {
        super("maps/house.tmx", 32f, screen);
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

    }

    @Override
    protected void initEffects() {
    }

    @Override
    protected void initSensors() {

    }
}
