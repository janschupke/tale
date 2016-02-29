package eu.janschupke.buddy.content.stage.level.settlement;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.content.entity.PlayerUnit;
import eu.janschupke.buddy.content.stage.level.settlement.obstacle.blacksmith.BlacksmithObstacle;
import eu.janschupke.buddy.content.stage.level.settlement.obstacle.chobo_house.ChoboHouseObstacle;
import eu.janschupke.buddy.content.stage.level.settlement.obstacle.dungeon.DungeonObstacle;
import eu.janschupke.buddy.content.stage.level.settlement.obstacle.farm.FarmObstacle;
import eu.janschupke.buddy.content.stage.level.settlement.obstacle.fountain.FountainObstacle;
import eu.janschupke.buddy.content.stage.level.settlement.obstacle.road_sign.RoadSignObstacle;
import eu.janschupke.buddy.content.stage.level.settlement.obstacle.tavern.TavernObstacle;
import eu.janschupke.buddy.content.stage.level.settlement.sensor.ChoboExplorationSensor;
import eu.janschupke.buddy.content.stage.level.settlement.sensor.DungeonExplorationSensor;
import eu.janschupke.buddy.content.stage.level.settlement.sensor.OutskirtsTransitionSensor;
import eu.janschupke.buddy.content.stage.level.settlement.unit.chobo.ChoboUnit;
import eu.janschupke.buddy.content.stage.level.settlement.unit.smith.SmithUnit;
import eu.janschupke.buddy.framework.base.entity.Obstacle;
import eu.janschupke.buddy.framework.base.entity.Sensor;
import eu.janschupke.buddy.framework.base.entity.Unit;
import eu.janschupke.buddy.framework.base.world.TopDownWorld;

/**
 * World for the settlement level.
 *
 * @author jan.schupke@gmail.com
 */
public class SettlementWorld extends TopDownWorld {
    public SettlementWorld(SettlementScreen screen) {
        super("maps/settlement.tmx", 32f, screen);
    }

    @Override
    protected void initPlayer() {
        setSpawnPoint(5, 45);
        setPlayerUnit(new PlayerUnit(this));
        positionPlayerUnit();
    }

    @Override
    protected void initCreatures() {
        Unit choboUnit = new ChoboUnit(this);
        choboUnit.setPosition(42, 6);
        getUnits().add(choboUnit);

        Unit smithUnit = new SmithUnit(this);
        smithUnit.setPosition(30, 42);
        getUnits().add(smithUnit);
    }

    @Override
    protected void initItems() {
    }

    @Override
    protected void initObstacles() {
        Obstacle blacksmithObstacle = new BlacksmithObstacle(this, new Vector2(5, 5));
        blacksmithObstacle.setPosition(42, 48);
        getObstacles().add(blacksmithObstacle);

        Obstacle choboHouseObstacle = new ChoboHouseObstacle(this, new Vector2(7, 7));
        choboHouseObstacle.setPosition(34, 5);
        getObstacles().add(choboHouseObstacle);

        Obstacle dungeonObstacle = new DungeonObstacle(this, new Vector2(4, 10));
        dungeonObstacle.setPosition(17, 8);
        getObstacles().add(dungeonObstacle);

        Obstacle farmObstacle = new FarmObstacle(this, new Vector2(5, 5));
        farmObstacle.setPosition(27, 36);
        getObstacles().add(farmObstacle);

        Obstacle fountainObstacle = new FountainObstacle(this, new Vector2(3, 3));
        fountainObstacle.setPosition(35, 41);
        getObstacles().add(fountainObstacle);

        Obstacle roadSignObstacle = new RoadSignObstacle(this, new Vector2(2, 2));
        roadSignObstacle.setPosition(8, 46);
        getObstacles().add(roadSignObstacle);

        Obstacle tavernObstacle = new TavernObstacle(this, new Vector2(5, 5));
        tavernObstacle.setPosition(50, 38);
        getObstacles().add(tavernObstacle);
    }

    @Override
    protected void initEffects() {
    }

    @Override
    protected void initSensors() {
        Sensor choboExplorationSensor = new ChoboExplorationSensor(this, new Vector2(10, 0.5f));
        choboExplorationSensor.setPosition(46, 18);

        Sensor dungeonExplorationSensor = new DungeonExplorationSensor(this, new Vector2(10, 0.5f));
        dungeonExplorationSensor.setPosition(10, 20);

        Sensor outskirtsTransitionSensor = new OutskirtsTransitionSensor(this, new Vector2(0.5f, 10));
        outskirtsTransitionSensor.setPosition(3, 40);
    }
}
