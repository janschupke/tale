package io.schupke.tale.content.stage.level.forest;

import com.badlogic.gdx.math.Vector2;

import io.schupke.tale.base.entity.Item;
import io.schupke.tale.base.entity.Obstacle;
import io.schupke.tale.base.entity.Sensor;
import io.schupke.tale.base.entity.Unit;
import io.schupke.tale.base.entity.Wall;
import io.schupke.tale.base.world.TopDownWorld;
import io.schupke.tale.content.config.Config;
import io.schupke.tale.content.entity.PlayerUnit;
import io.schupke.tale.content.stage.level.forest.item.coin.CoinItem;
import io.schupke.tale.content.stage.level.forest.obstacle.OutskirtsTransitionWall;
import io.schupke.tale.content.stage.level.forest.obstacle.caravan.CaravanObstacle;
import io.schupke.tale.content.stage.level.forest.sensor.EastExplorationSensor;
import io.schupke.tale.content.stage.level.forest.sensor.IntroSensor;
import io.schupke.tale.content.stage.level.forest.sensor.ItemIntroSensor;
import io.schupke.tale.content.stage.level.forest.sensor.NorthExplorationSensor;
import io.schupke.tale.content.stage.level.forest.sensor.OutskirtsTransitionSensor;
import io.schupke.tale.content.stage.level.forest.sensor.SouthExplorationSensor;
import io.schupke.tale.content.stage.level.forest.sensor.UnitIntroSensor;
import io.schupke.tale.content.stage.level.forest.unit.ukko.UkkoUnit;

/**
 * Forest (Tutorial) world.
 * Implements the tutorial level with basic game mechanics.
 */
public class ForestWorld extends TopDownWorld {
    private Unit ukkoUnit;
    private Item goldCoinItem;

    public ForestWorld(ForestScreen screen) {
        super("maps/forest.tmx", 32f, screen);
    }

    @Override
    protected void debugReposition() {
        if (!Config.DEBUG_OBJECT_POSITION) {
            return;
        }

        setSpawnPoint(45, 32);
        positionPlayerUnit();
        goldCoinItem.setPosition(getPlayerUnit().getX() - 2, getPlayerUnit().getY() - 1);
        ukkoUnit.setPosition(getPlayerUnit().getX() - 2, getPlayerUnit().getY() + 1);
    }

    @Override
    protected void initPlayer() {
        setSpawnPoint(30, 17);
        setPlayerUnit(new PlayerUnit(this));
        positionPlayerUnit();
    }

    @Override
    protected void initCreatures() {
        ukkoUnit = new UkkoUnit(this);
        ukkoUnit.setPosition(28, 36);
        getUnits().add(ukkoUnit);
    }

    @Override
    protected void initItems() {
        goldCoinItem = new CoinItem(this);
        goldCoinItem.setPosition(19, 17);
        getItems().add(goldCoinItem);
    }

    @Override
    protected void initObstacles() {
//        Wall initialWall = new InitialWall(this, new Vector2(7, 0.5f));
//        initialWall.setPosition(15, 25);
//        getObstacles().add(initialWall);

//        Wall questWall = new QuestWall(this, new Vector2(5, 0.5f));
//        questWall.setPosition(47, 36);
//        getObstacles().add(questWall);

        Obstacle caravanObstacle = new CaravanObstacle(this, 4);
        caravanObstacle.setPosition(46, 19);
        getObstacles().add(caravanObstacle);

        Wall outskirtsTransitionWall = new OutskirtsTransitionWall(this, new Vector2(5, 0.5f));
        outskirtsTransitionWall.setPosition(47, 43);
        getObstacles().add(outskirtsTransitionWall);
    }

    @Override
    protected void initEffects() {
    }

    @Override
    protected void initSensors() {
        Sensor introSensor = new IntroSensor(this, new Vector2(0.5f, 5));
        introSensor.setPosition(28, 16);

        Sensor itemIntroSensor = new ItemIntroSensor(this, new Vector2(0.5f, 5));
        itemIntroSensor.setPosition(23, 16);

        Sensor unitIntroSensor = new UnitIntroSensor(this, new Vector2(7, 0.5f));
        unitIntroSensor.setPosition(18, 34);

        Sensor outskirtsTransitionSensor = new OutskirtsTransitionSensor(this, new Vector2(5, 0.5f));
        outskirtsTransitionSensor.setPosition(47, 42);

        Sensor southExplorationSensor = new SouthExplorationSensor(this, new Vector2(5, 0.5f));
        southExplorationSensor.setPosition(17, 12);

        Sensor northExplorationSensor = new NorthExplorationSensor(this, new Vector2(5, 0.5f));
        northExplorationSensor.setPosition(12, 45);

        Sensor eastExplorationSensor = new EastExplorationSensor(this, new Vector2(5, 0.5f));
        eastExplorationSensor.setPosition(47, 25);
    }
}
