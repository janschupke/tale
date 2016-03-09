package eu.janschupke.tale.content.stage.level.house;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.content.config.Config;
import eu.janschupke.tale.content.entity.PlayerUnit;
import eu.janschupke.tale.content.stage.level.house.item.book.BookItem;
import eu.janschupke.tale.content.stage.level.house.item.mead.MeadItem;
import eu.janschupke.tale.content.stage.level.house.obstacle.bed.BedObstacle;
import eu.janschupke.tale.content.stage.level.house.obstacle.book_shelf.BookShelfObstacle;
import eu.janschupke.tale.content.stage.level.house.sensor.FarExplorationSensor;
import eu.janschupke.tale.content.stage.level.house.sensor.RoomExplorationSensor;
import eu.janschupke.tale.content.stage.level.house.sensor.SettlementTransitionSensor;
import eu.janschupke.tale.framework.entity.Item;
import eu.janschupke.tale.framework.entity.Obstacle;
import eu.janschupke.tale.framework.entity.Sensor;
import eu.janschupke.tale.framework.world.TopDownWorld;

/**
 * World for the house level.
 *
 * @author jan.schupke@gmail.com
 */
public class HouseWorld extends TopDownWorld {
    public HouseWorld(HouseScreen screen) {
        super("maps/house.tmx", 32f, screen);
    }

    @Override
    protected void debugReposition() {
        if (!Config.DEBUG_MODE) {
            return;
        }
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
        Item bookItem = new BookItem(this);
        bookItem.setPosition(1, 1);
        getItems().add(bookItem);

        Item meadItem = new MeadItem(this);
        meadItem.setPosition(1, 1);
        getItems().add(meadItem);
    }

    @Override
    protected void initObstacles() {
        Obstacle bedObstacle = new BedObstacle(this, new Vector2(2, 2));
        bedObstacle.setPosition(1, 1);
        getObstacles().add(bedObstacle);

        Obstacle bookShelfObstacle = new BookShelfObstacle(this, new Vector2(2, 2));
        bookShelfObstacle.setPosition(1, 1);
        getObstacles().add(bookShelfObstacle);
    }

    @Override
    protected void initEffects() {
    }

    @Override
    protected void initSensors() {
        Sensor farExplorationSensor = new FarExplorationSensor(this, new Vector2(5, 0.5f));
        farExplorationSensor.setPosition(1, 1);

        Sensor roomExplorationSensor = new RoomExplorationSensor(this, new Vector2(5, 0.5f));
        roomExplorationSensor.setPosition(1, 1);

        Sensor settlementTransitionSensor = new SettlementTransitionSensor(this, new Vector2(5, 0.5f));
        settlementTransitionSensor.setPosition(1, 1);
    }
}
