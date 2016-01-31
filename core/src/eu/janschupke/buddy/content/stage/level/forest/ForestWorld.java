package eu.janschupke.buddy.content.stage.level.forest;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.content.entity.creature.Player;
import eu.janschupke.buddy.content.entity.creature.Ukko;
import eu.janschupke.buddy.content.entity.obstacle.Cave;
import eu.janschupke.buddy.content.entity.sensor.CaveSensor;
import eu.janschupke.buddy.framework.base.entity.Sensor;
import eu.janschupke.buddy.framework.base.entity.Unit;
import eu.janschupke.buddy.framework.base.world.TopDownWorld;

/**
 * Forest (Tutorial) world.
 */
public class ForestWorld extends TopDownWorld {
    public ForestWorld() {
        super("maps/forest.tmx", 32f);
    }

    @Override
    protected void initPlayer() {
        setSpawnPoint(24, 5);
        setPlayerUnit(new Player(this));
        positionPlayerUnit();
    }

    @Override
    protected void initCreatures() {
        Unit u = new Ukko(this);
        u.setPosition(18, 18);
        getUnits().add(u);
    }

    @Override
    protected void initItems() {

    }

    @Override
    protected void initObstacles() {
        Cave cave = new Cave(this);
        cave.setPosition(20, 18);
        getObstacles().add(cave);
    }

    @Override
    protected void initEffects() {

    }

    @Override
    protected void initSensors() {
        Sensor caveSensor = new CaveSensor(this, new Vector2(1, 3));
        caveSensor.setPosition(21, 3);
    }
}

