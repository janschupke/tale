package io.schupke.tale.content.stage.level.dungeon;

import com.badlogic.gdx.math.Vector2;
import io.schupke.tale.base.entity.Item;
import io.schupke.tale.base.entity.Obstacle;
import io.schupke.tale.base.entity.Sensor;
import io.schupke.tale.base.world.TopDownWorld;
import io.schupke.tale.content.config.Config;
import io.schupke.tale.content.entity.PlayerUnit;
import io.schupke.tale.content.stage.level.dungeon.item.chest.ChestItem;
import io.schupke.tale.content.stage.level.dungeon.obstacle.gate.GateObstacle;
import io.schupke.tale.content.stage.level.dungeon.obstacle.harpsichord.HarpsichordObstacle;
import io.schupke.tale.content.stage.level.dungeon.sensor.ExitTransitionSensor;
import io.schupke.tale.content.stage.level.dungeon.sensor.ExitWarningSensor;
import io.schupke.tale.content.stage.level.dungeon.sensor.SettlementTransitionSensor;
import io.schupke.tale.content.stage.level.dungeon.sensor.StudyExplorationSensor;

/**
 * World for the dungeon level.
 *
 * @author jan.schupke@gmail.com
 */
public class DungeonWorld extends TopDownWorld {
    private Item chestItem;
    private Obstacle harpsichordObstacle;
    private Obstacle gateObstacle;
    private Sensor exitTransitionSensor;
    private Sensor exitWarningSensor;

    public DungeonWorld(DungeonScreen screen) {
        super("maps/dungeon.tmx", 32f, screen);
    }

    @Override
    protected void debugReposition() {
        if (!Config.DEBUG_OBJECT_POSITION) {
            return;
        }

        chestItem.setPosition(getPlayerUnit().getX() - 2, getPlayerUnit().getY() - 2);
        harpsichordObstacle.setPosition(getPlayerUnit().getX() - 5, getPlayerUnit().getY() - 2);
        gateObstacle.setPosition(getPlayerUnit().getX() + 2, getPlayerUnit().getY() - 2);
        exitTransitionSensor.setPosition(getPlayerUnit().getX() + 8, getPlayerUnit().getY() - 3);
        exitWarningSensor.setPosition(getPlayerUnit().getX() + 5, getPlayerUnit().getY() - 3);
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
        chestItem = new ChestItem(this);
        chestItem.setPosition(36, 49);
        getItems().add(chestItem);
    }

    @Override
    protected void initObstacles() {
        harpsichordObstacle = new HarpsichordObstacle(this, new Vector2(1.7f, 2));
        harpsichordObstacle.setPosition(18, 23);
        getObstacles().add(harpsichordObstacle);

        gateObstacle = new GateObstacle(this, new Vector2(1, 2));
        gateObstacle.setPosition(40, 45);
        getObstacles().add(gateObstacle);
    }

    @Override
    protected void initEffects() {
    }

    @Override
    protected void initSensors() {
        exitWarningSensor = new ExitWarningSensor(this, new Vector2(0.5f, 5));
        exitWarningSensor.setPosition(44, 43);

        exitTransitionSensor = new ExitTransitionSensor(this, new Vector2(0.5f, 5));
        exitTransitionSensor.setPosition(47, 43);

        Sensor settlementTransitionSensor = new SettlementTransitionSensor(this, new Vector2(5, 0.5f));
        settlementTransitionSensor.setPosition(12, 55);

        Sensor studyExplorationSensor = new StudyExplorationSensor(this, new Vector2(5, 0.5f));
        studyExplorationSensor.setPosition(23, 38);
    }
}
