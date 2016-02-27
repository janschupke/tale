package eu.janschupke.buddy.content.stage.level.forest;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.content.entity.PlayerUnit;
import eu.janschupke.buddy.content.stage.level.forest.item.GoldCoinItem;
import eu.janschupke.buddy.content.stage.level.forest.obstacle.InitialWall;
import eu.janschupke.buddy.content.stage.level.forest.sensor.IntroSensor;
import eu.janschupke.buddy.content.stage.level.forest.sensor.ItemHintSensor;
import eu.janschupke.buddy.content.stage.level.forest.unit.UkkoUnit;
import eu.janschupke.buddy.framework.base.entity.Item;
import eu.janschupke.buddy.framework.base.entity.Sensor;
import eu.janschupke.buddy.framework.base.entity.Unit;
import eu.janschupke.buddy.framework.base.entity.Wall;
import eu.janschupke.buddy.framework.base.world.TopDownWorld;

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
    }

    @Override
    protected void initEffects() {
    }

    @Override
    protected void initSensors() {
        Sensor introSensor = new IntroSensor(this, new Vector2(0.5f, 5));
        introSensor.setPosition(28, 16);

        Sensor itemHintSensor = new ItemHintSensor(this, new Vector2(0.5f, 5));
        itemHintSensor.setPosition(23, 16);
    }
}
