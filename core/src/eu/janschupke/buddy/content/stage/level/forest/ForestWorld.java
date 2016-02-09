package eu.janschupke.buddy.content.stage.level.forest;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.content.entity.PlayerUnit;
import eu.janschupke.buddy.content.stage.level.forest.item.GoldCoinItem;
import eu.janschupke.buddy.content.stage.level.forest.obstacle.CaveObstacle;
import eu.janschupke.buddy.content.stage.level.forest.obstacle.InitialWall;
import eu.janschupke.buddy.content.stage.level.forest.sensor.CaveSensor;
import eu.janschupke.buddy.content.stage.level.forest.sensor.IntroSensor;
import eu.janschupke.buddy.content.stage.level.forest.sensor.ItemHintSensor;
import eu.janschupke.buddy.content.stage.level.forest.unit.UkkoUnit;
import eu.janschupke.buddy.framework.base.entity.*;
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
        setSpawnPoint(27, 9);
        setPlayerUnit(new PlayerUnit(this));
        positionPlayerUnit();
    }

    @Override
    protected void initCreatures() {
        Unit u = new UkkoUnit(this);
        u.setPosition(20, 33);
        getUnits().add(u);
    }

    @Override
    protected void initItems() {
        Item goldCoinItem = new GoldCoinItem(this);
        goldCoinItem.setPosition(13, 10);
        getItems().add(goldCoinItem);
    }

    @Override
    protected void initObstacles() {
        Obstacle caveObstacle = new CaveObstacle(this, new Vector2(3, 3));
        caveObstacle.setPosition(23, 22);
        getObstacles().add(caveObstacle);

        Wall initialWall = new InitialWall(this, new Vector2(5, 0.5f));
        initialWall.setPosition(14, 16);
        getObstacles().add(initialWall);
    }

    @Override
    protected void initEffects() {}

    @Override
    protected void initSensors() {
        Sensor introSensor = new IntroSensor(this, new Vector2(0.5f, 3));
        introSensor.setPosition(26, 9);

        Sensor itemHintSensor = new ItemHintSensor(this, new Vector2(0.5f, 5));
        itemHintSensor.setPosition(22, 9);

        Sensor caveSensor = new CaveSensor(this, new Vector2(5, 0.5f));
        caveSensor.setPosition(14, 18);
    }
}

