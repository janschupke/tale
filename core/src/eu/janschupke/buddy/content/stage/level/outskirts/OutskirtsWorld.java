package eu.janschupke.buddy.content.stage.level.outskirts;

import eu.janschupke.buddy.content.entity.PlayerUnit;
import eu.janschupke.buddy.framework.base.world.TopDownWorld;

/**
 * Outskirts (Level 1) world.
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

    }

    @Override
    protected void initEffects() {}

    @Override
    protected void initSensors() {

    }
}
