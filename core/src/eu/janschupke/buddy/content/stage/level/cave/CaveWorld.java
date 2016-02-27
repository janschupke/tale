package eu.janschupke.buddy.content.stage.level.cave;

import eu.janschupke.buddy.content.entity.PlayerUnit;
import eu.janschupke.buddy.framework.base.world.TopDownWorld;

/**
 * World for the cave level.
 *
 * @author jan.schupke@gmail.com
 */
public class CaveWorld extends TopDownWorld {
    public CaveWorld(CaveScreen screen) {
        super("maps/cave.tmx", 32f, screen);
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
