package eu.janschupke.buddy.content.stage.level.forest;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.content.entity.PlayerUnit;
import eu.janschupke.buddy.content.stage.level.forest.item.GoldCoinItem;
import eu.janschupke.buddy.content.stage.level.forest.obstacle.CaveObstacle;
import eu.janschupke.buddy.content.stage.level.forest.sensor.CaveSensor;
import eu.janschupke.buddy.content.stage.level.forest.sensor.IntroSensor;
import eu.janschupke.buddy.content.stage.level.forest.unit.UkkoUnit;
import eu.janschupke.buddy.framework.base.entity.Item;
import eu.janschupke.buddy.framework.base.entity.Obstacle;
import eu.janschupke.buddy.framework.base.entity.Sensor;
import eu.janschupke.buddy.framework.base.entity.Unit;
import eu.janschupke.buddy.framework.base.world.TopDownWorld;

/**
 * Forest (Tutorial) world.
 */
public class ForestWorld extends TopDownWorld {
    public ForestWorld(ForestScreen screen) {
        super("maps/forest.tmx", 32f, screen);
    }

    @Override
    protected void initPlayer() {
        setSpawnPoint(24, 5);
        setPlayerUnit(new PlayerUnit(this));
        positionPlayerUnit();
    }

    @Override
    protected void initCreatures() {
        Unit u = new UkkoUnit(this);
        u.setPosition(18, 18);
        getUnits().add(u);
    }

    @Override
    protected void initItems() {
        Item goldCoinItem = new GoldCoinItem(this);
        goldCoinItem.setPosition(15, 4);
        getItems().add(goldCoinItem);
    }

    @Override
    protected void initObstacles() {
        Obstacle caveObstacle = new CaveObstacle(this);
        caveObstacle.setPosition(20, 18);
        getObstacles().add(caveObstacle);
    }

    @Override
    protected void initEffects() {

    }

    @Override
    protected void initSensors() {
        Sensor introSensor = new IntroSensor(this, new Vector2(0.5f, 3));
        introSensor.setPosition(23, 3);

        Sensor caveSensor = new CaveSensor(this, new Vector2(3, 1));
        caveSensor.setPosition(14, 13);
    }
}

