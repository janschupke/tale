package eu.janschupke.buddy.content.stage.level.dungeon;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.content.entity.PlayerUnit;
import eu.janschupke.buddy.content.stage.level.dungeon.item.book_one.BookOneItem;
import eu.janschupke.buddy.content.stage.level.dungeon.item.chest.ChestItem;
import eu.janschupke.buddy.content.stage.level.dungeon.item.rune.RuneItem;
import eu.janschupke.buddy.content.stage.level.dungeon.item.scroll.ScrollItem;
import eu.janschupke.buddy.content.stage.level.dungeon.obstacle.TableObstacle;
import eu.janschupke.buddy.content.stage.level.dungeon.obstacle.harpsichord.HarpsichordObstacle;
import eu.janschupke.buddy.content.stage.level.dungeon.obstacle.room_four_door.RoomFourDoorObstacle;
import eu.janschupke.buddy.content.stage.level.dungeon.obstacle.room_one_gate.RoomOneGateObstacle;
import eu.janschupke.buddy.content.stage.level.dungeon.obstacle.room_two_door.RoomTwoDoorObstacle;
import eu.janschupke.buddy.content.stage.level.dungeon.sensor.ExitTransitionSensor;
import eu.janschupke.buddy.content.stage.level.dungeon.sensor.SettlementTransitionSensor;
import eu.janschupke.buddy.content.stage.level.dungeon.sensor.StudyExplorationSensor;
import eu.janschupke.buddy.content.stage.level.dungeon.unit.rudolf.RudolfUnit;
import eu.janschupke.buddy.content.stage.level.dungeon.unit.slave.SlaveUnit;
import eu.janschupke.buddy.framework.base.entity.Item;
import eu.janschupke.buddy.framework.base.entity.Obstacle;
import eu.janschupke.buddy.framework.base.entity.Sensor;
import eu.janschupke.buddy.framework.base.entity.Unit;
import eu.janschupke.buddy.framework.base.world.TopDownWorld;

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
        Unit rudolfUnit = new RudolfUnit(this);
        rudolfUnit.setPosition(40, 25);
        getUnits().add(rudolfUnit);

        Unit slaveUnit = new SlaveUnit(this);
        slaveUnit.setPosition(10, 40);
        getUnits().add(slaveUnit);
    }

    @Override
    protected void initItems() {
        Item bookOneItem = new BookOneItem(this);
        bookOneItem.setPosition(20, 20);
        getItems().add(bookOneItem);

        Item chestItem = new ChestItem(this);
        chestItem.setPosition(15, 25);
        getItems().add(chestItem);

        Item runeItem = new RuneItem(this);
        runeItem.setPosition(10, 50);
        getItems().add(runeItem);

        Item scrollItem = new ScrollItem(this);
        scrollItem.setPosition(10, 20);
        getItems().add(scrollItem);
    }

    @Override
    protected void initObstacles() {
        Obstacle harpsichordObstacle = new HarpsichordObstacle(this, new Vector2(2, 2));
        harpsichordObstacle.setPosition(37, 53);
        getObstacles().add(harpsichordObstacle);

        Obstacle roomFourDoorObstacle = new RoomFourDoorObstacle(this, new Vector2(2, 2));
        roomFourDoorObstacle.setPosition(13, 30);
        getObstacles().add(roomFourDoorObstacle);

        Obstacle roomOneGateObstacle = new RoomOneGateObstacle(this, new Vector2(2, 2));
        roomOneGateObstacle.setPosition(18, 42);
        getObstacles().add(roomOneGateObstacle);

        Obstacle roomTwoDoorObstacle = new RoomTwoDoorObstacle(this, new Vector2(2, 2));
        roomTwoDoorObstacle.setPosition(31, 47);
        getObstacles().add(roomTwoDoorObstacle);

        Obstacle tableObstacle = new TableObstacle(this, new Vector2(2, 2));
        tableObstacle.setPosition(20, 20);
        getObstacles().add(tableObstacle);
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
