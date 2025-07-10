package eu.janschupke.tale.content.stage.level.outskirts;

import com.badlogic.gdx.math.Vector2;

import eu.janschupke.tale.base.entity.Item;
import eu.janschupke.tale.base.entity.Obstacle;
import eu.janschupke.tale.base.entity.Sensor;
import eu.janschupke.tale.base.entity.Unit;
import eu.janschupke.tale.base.entity.Wall;
import eu.janschupke.tale.base.world.TopDownWorld;
import eu.janschupke.tale.content.config.Config;
import eu.janschupke.tale.content.entity.PlayerUnit;
import eu.janschupke.tale.content.stage.level.outskirts.item.lumber.LumberItem;
import eu.janschupke.tale.content.stage.level.outskirts.item.varpunen.VarpunenItem;
import eu.janschupke.tale.content.stage.level.outskirts.obstacle.ForestTransitionWall;
import eu.janschupke.tale.content.stage.level.outskirts.obstacle.SettlementTransitionWall;
import eu.janschupke.tale.content.stage.level.outskirts.obstacle.cave.CaveObstacle;
import eu.janschupke.tale.content.stage.level.outskirts.obstacle.crone_shack.CroneShackObstacle;
import eu.janschupke.tale.content.stage.level.outskirts.obstacle.jack_house.JackHouseObstacle;
import eu.janschupke.tale.content.stage.level.outskirts.obstacle.road_sign.RoadSignObstacle;
import eu.janschupke.tale.content.stage.level.outskirts.sensor.CaveExplorationSensor;
import eu.janschupke.tale.content.stage.level.outskirts.sensor.ForestTransitionSensor;
import eu.janschupke.tale.content.stage.level.outskirts.sensor.JackExplorationSensor;
import eu.janschupke.tale.content.stage.level.outskirts.sensor.SettlementTransitionSensor;
import eu.janschupke.tale.content.stage.level.outskirts.sensor.VarpunenExplorationSensor;
import eu.janschupke.tale.content.stage.level.outskirts.unit.crone.CroneUnit;
import eu.janschupke.tale.content.stage.level.outskirts.unit.jack.JackUnit;

/**
 * Outskirts (Level 1) world.
 * Implements the first main level with exploration and quests.
 */
public class OutskirtsWorld extends TopDownWorld {
    private Unit croneUnit;
    private Unit jackUnit;
    private Item lumberItem;
    private Item varpunenNoteItem;
    private Obstacle caveObstacle;

    public OutskirtsWorld(OutskirtsScreen screen) {
        super("maps/outskirts.tmx", 32f, screen);
    }

    @Override
    protected void debugReposition() {
        if (!Config.DEBUG_OBJECT_POSITION) {
            return;
        }

        setSpawnPoint(50, 40);
        positionPlayerUnit();

        croneUnit.setPosition(getPlayerUnit().getX() - 1, getPlayerUnit().getY() + 1);
        varpunenNoteItem.setPosition(getPlayerUnit().getX() + 1, getPlayerUnit().getY() + 1);
        jackUnit.setPosition(getPlayerUnit().getX() - 1, getPlayerUnit().getY() + 3);
        lumberItem.setPosition(getPlayerUnit().getX() + 1, getPlayerUnit().getY() + 3);
        caveObstacle.setPosition(getPlayerUnit().getX() - 4, getPlayerUnit().getY() + 2);
    }

    @Override
    protected void initPlayer() {
        setSpawnPoint(20, 10);
        setPlayerUnit(new PlayerUnit(this));
        positionPlayerUnit();
    }

    @Override
    protected void initCreatures() {
        croneUnit = new CroneUnit(this);
        croneUnit.setPosition(35, 36);
        getUnits().add(croneUnit);

        jackUnit = new JackUnit(this);
        jackUnit.setPosition(8, 53);
        getUnits().add(jackUnit);
    }

    @Override
    protected void initItems() {
        lumberItem = new LumberItem(this);
        lumberItem.setPosition(32, 52);
        getItems().add(lumberItem);

        varpunenNoteItem = new VarpunenItem(this);
        varpunenNoteItem.setPosition(10, 27);
        getItems().add(varpunenNoteItem);
    }

    @Override
    protected void initObstacles() {
        caveObstacle = new CaveObstacle(this, new Vector2(3, 2.3f));
        caveObstacle.setPosition(40, 14);
        getObstacles().add(caveObstacle);

        Obstacle croneShackObstacle = new CroneShackObstacle(this, new Vector2(3, 2.8f));
        croneShackObstacle.setPosition(38, 35);
        getObstacles().add(croneShackObstacle);

        Obstacle jackHouseObstacle = new JackHouseObstacle(this, new Vector2(3, 2.7f));
        jackHouseObstacle.setPosition(11, 53);
        getObstacles().add(jackHouseObstacle);

        Obstacle roadSignObstacle = new RoadSignObstacle(this, new Vector2(1.2f, 1.5f));
        roadSignObstacle.setPosition(32, 38);
        getObstacles().add(roadSignObstacle);

        Wall settlementTransitionWall = new SettlementTransitionWall(this, new Vector2(0.5f, 5));
        settlementTransitionWall.setPosition(55, 41);
        getObstacles().add(settlementTransitionWall);

        Wall forestTransitionWall = new ForestTransitionWall(this, new Vector2(5, 0.5f));
        forestTransitionWall.setPosition(16, 7);
        getObstacles().add(forestTransitionWall);
    }

    @Override
    protected void initEffects() {
    }

    @Override
    protected void initSensors() {
        Sensor caveExplorationSensor = new CaveExplorationSensor(this, new Vector2(5, 0.5f));
        caveExplorationSensor.setPosition(49, 25);

        Sensor forestTransitionSensor = new ForestTransitionSensor(this, new Vector2(5, 0.5f));
        forestTransitionSensor.setPosition(16, 8);

        Sensor jackExplorationSensor = new JackExplorationSensor(this, new Vector2(7, 0.5f));
        jackExplorationSensor.setPosition(12, 44);

        Sensor settlementTransitionSensor = new SettlementTransitionSensor(this, new Vector2(0.5f, 5));
        settlementTransitionSensor.setPosition(54, 41);

        Sensor varpunenExplorationSensor = new VarpunenExplorationSensor(this, new Vector2(5, 0.5f));
        varpunenExplorationSensor.setPosition(6, 40);
    }
}
