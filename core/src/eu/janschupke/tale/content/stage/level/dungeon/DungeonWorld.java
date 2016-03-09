package eu.janschupke.tale.content.stage.level.dungeon;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.content.entity.PlayerUnit;
import eu.janschupke.tale.content.stage.level.dungeon.item.book.BookItem;
import eu.janschupke.tale.content.stage.level.dungeon.item.chest.ChestItem;
import eu.janschupke.tale.content.stage.level.dungeon.item.scroll.ScrollItem;
import eu.janschupke.tale.content.stage.level.dungeon.obstacle.door.DoorObstacle;
import eu.janschupke.tale.content.stage.level.dungeon.obstacle.gate.GateObstacle;
import eu.janschupke.tale.content.stage.level.dungeon.obstacle.harpsichord.HarpsichordObstacle;
import eu.janschupke.tale.content.stage.level.dungeon.sensor.ExitTransitionSensor;
import eu.janschupke.tale.content.stage.level.dungeon.sensor.SettlementTransitionSensor;
import eu.janschupke.tale.content.stage.level.dungeon.sensor.StudyExplorationSensor;
import eu.janschupke.tale.framework.entity.Item;
import eu.janschupke.tale.framework.entity.Obstacle;
import eu.janschupke.tale.framework.entity.Sensor;
import eu.janschupke.tale.framework.world.TopDownWorld;

/**
 * World for the dungeon level.
 *
 * @author jan.schupke@gmail.com
 */
public class DungeonWorld extends TopDownWorld {
    public DungeonWorld(DungeonScreen screen) {
        super("maps/dungeon.tmx", 32f, screen);
    }

    @Override
    protected void initPlayer() {
        setSpawnPoint(14, 50);
        setPlayerUnit(new PlayerUnit(this));
        positionPlayerUnit();
    }

    @Override
    protected void initCreatures() {

    }

    @Override
    protected void initItems() {
        Item bookOneItem = new BookItem(this);
        bookOneItem.setPosition(20, 20);
        getItems().add(bookOneItem);

        Item chestItem = new ChestItem(this);
        chestItem.setPosition(15, 25);
        getItems().add(chestItem);

        Item scrollItem = new ScrollItem(this);
        scrollItem.setPosition(10, 20);
        getItems().add(scrollItem);
    }

    @Override
    protected void initObstacles() {
        Obstacle harpsichordObstacle = new HarpsichordObstacle(this, new Vector2(2, 2));
        harpsichordObstacle.setPosition(37, 53);
        getObstacles().add(harpsichordObstacle);

        Obstacle roomFourDoorObstacle = new DoorObstacle(this, new Vector2(2, 2));
        roomFourDoorObstacle.setPosition(13, 30);
        getObstacles().add(roomFourDoorObstacle);

        Obstacle roomOneGateObstacle = new GateObstacle(this, new Vector2(2, 2));
        roomOneGateObstacle.setPosition(18, 42);
        getObstacles().add(roomOneGateObstacle);
    }

    @Override
    protected void initEffects() {
    }

    @Override
    protected void initSensors() {
        Sensor exitTransitionSensor = new ExitTransitionSensor(this, new Vector2(0.5f, 5));
        exitTransitionSensor.setPosition(1, 1);

        Sensor settlementTransitionSensor = new SettlementTransitionSensor(this, new Vector2(5, 0.5f));
        settlementTransitionSensor.setPosition(12, 53);

        Sensor studyExplorationSensor = new StudyExplorationSensor(this, new Vector2(5, 0.5f));
        studyExplorationSensor.setPosition(23, 38);
    }
}
