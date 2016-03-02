package eu.janschupke.tale.content.stage.level.forest;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.content.entity.PlayerUnit;
import eu.janschupke.tale.content.stage.level.forest.item.coin.GoldCoinItem;
import eu.janschupke.tale.content.stage.level.forest.obstacle.InitialWall;
import eu.janschupke.tale.content.stage.level.forest.obstacle.QuestWall;
import eu.janschupke.tale.content.stage.level.forest.obstacle.caravan.CaravanObstacle;
import eu.janschupke.tale.content.stage.level.forest.sensor.*;
import eu.janschupke.tale.content.stage.level.forest.unit.ukko.UkkoUnit;
import eu.janschupke.tale.framework.base.entity.*;
import eu.janschupke.tale.framework.base.world.TopDownWorld;

/**
 * Forest (Tutorial) world.
 *
 * @author jan.schupke@gmail.com
 */
public class ForestWorld extends TopDownWorld {
    public ForestWorld(ForestScreen screen) {
        super("maps/forest.tmx", 32f, screen);
    }

    @Override
    protected void initPlayer() {
        setSpawnPoint(30, 17);
        setPlayerUnit(new PlayerUnit(this));
        positionPlayerUnit();
    }

    @Override
    protected void initCreatures() {
        Unit u = new UkkoUnit(this);
        u.setPosition(28, 36);
        getUnits().add(u);
    }

    @Override
    protected void initItems() {
        Item goldCoinItem = new GoldCoinItem(this);
        goldCoinItem.setPosition(19, 17);
        getItems().add(goldCoinItem);
    }

    @Override
    protected void initObstacles() {
        Wall initialWall = new InitialWall(this, new Vector2(7, 0.5f));
        initialWall.setPosition(15, 25);
        getObstacles().add(initialWall);

        Wall questWall = new QuestWall(this, new Vector2(5, 0.5f));
        questWall.setPosition(47, 36);
        getObstacles().add(questWall);

        Obstacle caravanObstacle = new CaravanObstacle(this, new Vector2(4, 4));
        caravanObstacle.setPosition(46, 19);
        getObstacles().add(caravanObstacle);
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
        southExplorationSensor.setPosition(18, 12);

        Sensor northExplorationSensor = new NorthExplorationSensor(this, new Vector2(5, 0.5f));
        northExplorationSensor.setPosition(12, 45);

        Sensor eastExplorationSensor = new EastExplorationSensor(this, new Vector2(5, 0.5f));
        eastExplorationSensor.setPosition(47, 25);
    }
}
