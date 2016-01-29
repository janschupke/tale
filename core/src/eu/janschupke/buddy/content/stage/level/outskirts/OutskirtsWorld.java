package eu.janschupke.buddy.content.stage.level.outskirts;

import eu.janschupke.buddy.content.entity.creature.Player;
import eu.janschupke.buddy.framework.base.world.TopDownWorld;

/**
 * Outskirts (Level 1) world.
 */
public class OutskirtsWorld extends TopDownWorld {
    public OutskirtsWorld() {
        super("maps/outskirts.tmx", 32f);
    }

    @Override
    protected void initPlayer() {
        setSpawnPoint(5, 5);
        setPlayerUnit(new Player(this));
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
}
