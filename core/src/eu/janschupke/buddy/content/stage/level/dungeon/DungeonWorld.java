package eu.janschupke.buddy.content.stage.level.dungeon;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.content.entity.PlayerUnit;
import eu.janschupke.buddy.content.stage.level.dungeon.item.PoisonItem;
import eu.janschupke.buddy.content.stage.level.dungeon.item.RoomOneKeyItem;
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
        setSpawnPoint(5, 5);
        setPlayerUnit(new PlayerUnit(this));
        positionPlayerUnit();
    }

    @Override
    protected void initCreatures() {
        Unit rudolfUnit = new RudolfUnit(this);
        rudolfUnit.setPosition(1, 1);
        getUnits().add(rudolfUnit);

        Unit slaveUnit = new SlaveUnit(this);
        slaveUnit.setPosition(1, 1);
        getUnits().add(slaveUnit);
    }

    @Override
    protected void initItems() {
        Item bookOneItem = new BookOneItem(this);
        bookOneItem.setPosition(1, 1);
        getItems().add(bookOneItem);

        Item chestItem = new ChestItem(this);
        chestItem.setPosition(1, 1);
        getItems().add(chestItem);

        Item runeItem = new RuneItem(this);
        runeItem.setPosition(1, 1);
        getItems().add(runeItem);

        Item scrollItem = new ScrollItem(this);
        scrollItem.setPosition(1, 1);
        getItems().add(scrollItem);

        Item poisonItem = new PoisonItem(this);
        poisonItem.setPosition(1, 1);
        getItems().add(poisonItem);

        Item roomOneKeyItem = new RoomOneKeyItem(this);
        roomOneKeyItem.setPosition(1, 1);
        getItems().add(roomOneKeyItem);
    }

    @Override
    protected void initObstacles() {
        Obstacle harpsichordObstacle = new HarpsichordObstacle(this, new Vector2(2, 2));
        harpsichordObstacle.setPosition(1, 1);
        getObstacles().add(harpsichordObstacle);

        Obstacle roomFourDoorObstacle = new RoomFourDoorObstacle(this, new Vector2(2, 2));
        roomFourDoorObstacle.setPosition(1, 1);
        getObstacles().add(roomFourDoorObstacle);

        Obstacle roomOneGateObstacle = new RoomOneGateObstacle(this, new Vector2(2, 2));
        roomOneGateObstacle.setPosition(1, 1);
        getObstacles().add(roomOneGateObstacle);

        Obstacle roomTwoDoorObstacle = new RoomTwoDoorObstacle(this, new Vector2(2, 2));
        roomTwoDoorObstacle.setPosition(1, 1);
        getObstacles().add(roomTwoDoorObstacle);

        Obstacle tableObstacle = new TableObstacle(this, new Vector2(2, 2));
        tableObstacle.setPosition(1, 1);
        getObstacles().add(tableObstacle);
    }

    @Override
    protected void initEffects() {
    }

    @Override
    protected void initSensors() {
        Sensor exitTransitionSensor = new ExitTransitionSensor(this, new Vector2(0.5f, 5));
        exitTransitionSensor.setPosition(1, 1);

        Sensor settlementTransitionSensor = new SettlementTransitionSensor(this, new Vector2(0.5f, 5));
        settlementTransitionSensor.setPosition(1, 1);

        Sensor studyExplorationSensor = new StudyExplorationSensor(this, new Vector2(0.5f, 5));
        studyExplorationSensor.setPosition(1, 1);
    }
}
