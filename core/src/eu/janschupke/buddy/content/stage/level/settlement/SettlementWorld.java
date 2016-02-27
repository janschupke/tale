package eu.janschupke.buddy.content.stage.level.settlement;

import eu.janschupke.buddy.content.entity.PlayerUnit;
import eu.janschupke.buddy.framework.base.world.TopDownWorld;

/**
 * World for the settlement level.
 *
 * @author jan.schupke@gmail.com
 */
public class SettlementWorld extends TopDownWorld {
    public SettlementWorld(SettlementScreen screen) {
        super("maps/settlement.tmx", 32f, screen);
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
