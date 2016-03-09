package eu.janschupke.tale.content.stage.level.outskirts;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.content.entity.PlayerUnit;
import eu.janschupke.tale.content.stage.level.outskirts.item.lumber.LumberItem;
import eu.janschupke.tale.content.stage.level.outskirts.item.varpunen.VarpunenItem;
import eu.janschupke.tale.content.stage.level.outskirts.obstacle.ForestTransitionWall;
import eu.janschupke.tale.content.stage.level.outskirts.obstacle.SettlementTransitionWall;
import eu.janschupke.tale.content.stage.level.outskirts.obstacle.cave.CaveObstacle;
import eu.janschupke.tale.content.stage.level.outskirts.obstacle.crone_shack.CroneShackObstacle;
import eu.janschupke.tale.content.stage.level.outskirts.obstacle.jack_house.JackHouseObstacle;
import eu.janschupke.tale.content.stage.level.outskirts.obstacle.road_sign.RoadSignObstacle;
import eu.janschupke.tale.content.stage.level.outskirts.sensor.*;
import eu.janschupke.tale.content.stage.level.outskirts.unit.crone.CroneUnit;
import eu.janschupke.tale.content.stage.level.outskirts.unit.jack.JackUnit;
import eu.janschupke.tale.framework.entity.*;
import eu.janschupke.tale.framework.world.TopDownWorld;

/**
 * Outskirts (Level 1) world.
 *
 * @author jan.schupke@gmail.com
 */
public class OutskirtsWorld extends TopDownWorld {
    public OutskirtsWorld(OutskirtsScreen screen) {
        super("maps/outskirts.tmx", 32f, screen);
    }

    @Override
    protected void initPlayer() {
        setSpawnPoint(20, 10);
        setPlayerUnit(new PlayerUnit(this));
        positionPlayerUnit();
    }

    @Override
    protected void initCreatures() {
        Unit croneUnit = new CroneUnit(this);
        croneUnit.setPosition(35, 36);
        getUnits().add(croneUnit);

        Unit jackUnit = new JackUnit(this);
        jackUnit.setPosition(9, 53);
        getUnits().add(jackUnit);
    }

    @Override
    protected void initItems() {
        Item lumberItem = new LumberItem(this);
        lumberItem.setPosition(38, 57);
        getItems().add(lumberItem);

        Item varpunenNoteItem = new VarpunenItem(this);
        varpunenNoteItem.setPosition(7, 15);
        getItems().add(varpunenNoteItem);
    }

    @Override
    protected void initObstacles() {
        Obstacle caveObstacle = new CaveObstacle(this, new Vector2(3, 3));
        caveObstacle.setPosition(40, 10);
        getObstacles().add(caveObstacle);

        Obstacle croneShackObstacle = new CroneShackObstacle(this, new Vector2(3, 3));
        croneShackObstacle.setPosition(38, 35);
        getObstacles().add(croneShackObstacle);

        Obstacle jackHouseObstacle = new JackHouseObstacle(this, new Vector2(3, 3));
        jackHouseObstacle.setPosition(8, 56);
        getObstacles().add(jackHouseObstacle);

        Obstacle roadSignObstacle = new RoadSignObstacle(this, new Vector2(3, 3));
        roadSignObstacle.setPosition(30, 38);
        getObstacles().add(roadSignObstacle);

        Wall settlementTransitionWall = new SettlementTransitionWall(this, new Vector2(0.5f, 5));
        settlementTransitionWall.setPosition(59, 41);
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
        caveExplorationSensor.setPosition(54, 18);

        Sensor forestTransitionSensor = new ForestTransitionSensor(this, new Vector2(5, 0.5f));
        forestTransitionSensor.setPosition(16, 8);

        Sensor jackExplorationSensor = new JackExplorationSensor(this, new Vector2(5, 0.5f));
        jackExplorationSensor.setPosition(14, 40);

        Sensor settlementTransitionSensor = new SettlementTransitionSensor(this, new Vector2(0.5f, 5));
        settlementTransitionSensor.setPosition(58, 41);

        Sensor varpunenExplorationSensor = new VarpunenExplorationSensor(this, new Vector2(5, 0.5f));
        varpunenExplorationSensor.setPosition(5, 30);
    }
}
