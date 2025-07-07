package eu.janschupke.tale.content.stage.level.settlement;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.base.entity.Obstacle;
import eu.janschupke.tale.base.entity.Sensor;
import eu.janschupke.tale.base.entity.Unit;
import eu.janschupke.tale.base.entity.Wall;
import eu.janschupke.tale.base.world.TopDownWorld;
import eu.janschupke.tale.content.config.Config;
import eu.janschupke.tale.content.entity.PlayerUnit;
import eu.janschupke.tale.content.stage.level.settlement.obstacle.OutskirtsTransitionWall;
import eu.janschupke.tale.content.stage.level.settlement.obstacle.blacksmith.BlacksmithObstacle;
import eu.janschupke.tale.content.stage.level.settlement.obstacle.chobo_house.ChoboHouseObstacle;
import eu.janschupke.tale.content.stage.level.settlement.obstacle.dungeon.DungeonObstacle;
import eu.janschupke.tale.content.stage.level.settlement.obstacle.farm.FarmObstacle;
import eu.janschupke.tale.content.stage.level.settlement.obstacle.fountain.FountainObstacle;
import eu.janschupke.tale.content.stage.level.settlement.obstacle.road_sign.RoadSignObstacle;
import eu.janschupke.tale.content.stage.level.settlement.obstacle.tavern.TavernObstacle;
import eu.janschupke.tale.content.stage.level.settlement.sensor.ChoboExplorationSensor;
import eu.janschupke.tale.content.stage.level.settlement.sensor.DungeonExplorationSensor;
import eu.janschupke.tale.content.stage.level.settlement.sensor.OutskirtsTransitionSensor;
import eu.janschupke.tale.content.stage.level.settlement.unit.chobo.ChoboUnit;
import eu.janschupke.tale.content.stage.level.settlement.unit.smith.SmithUnit;

/**
 * World for the settlement level.
 *
 * @author jan.schupke@gmail.com
 */
public class SettlementWorld extends TopDownWorld {
    private Unit smithUnit;
    private Obstacle blacksmithObstacle;
    private Unit choboUnit;
    private Obstacle dungeonObstacle;

    public SettlementWorld(SettlementScreen screen) {
        super("maps/settlement.tmx", 32f, screen);
    }

    @Override
    protected void debugReposition() {
        if (!Config.DEBUG_OBJECT_POSITION) {
            return;
        }

        smithUnit.setPosition(getPlayerUnit().getX() + 2, getPlayerUnit().getY() - 2);
        blacksmithObstacle.setPosition(getPlayerUnit().getX() - 1, getPlayerUnit().getY() - 8);
        choboUnit.setPosition(getPlayerUnit().getX(), getPlayerUnit().getY() - 2);
        dungeonObstacle.setPosition(getPlayerUnit().getX() + 6, getPlayerUnit().getY() - 4);
    }

    @Override
    protected void initPlayer() {
        setSpawnPoint(10, 45);
        setPlayerUnit(new PlayerUnit(this));
        positionPlayerUnit();
    }

    @Override
    protected void initCreatures() {
        choboUnit = new ChoboUnit(this);
        choboUnit.setPosition(44, 21);
        getUnits().add(choboUnit);

        smithUnit = new SmithUnit(this);
        smithUnit.setPosition(30, 42);
        getUnits().add(smithUnit);
    }

    @Override
    protected void initItems() {
    }

    @Override
    protected void initObstacles() {
        blacksmithObstacle = new BlacksmithObstacle(this, 5);
        blacksmithObstacle.setPosition(33, 46);
        getObstacles().add(blacksmithObstacle);

        Obstacle choboHouseObstacle = new ChoboHouseObstacle(this, 7);
        choboHouseObstacle.setPosition(36, 16);
        getObstacles().add(choboHouseObstacle);

        dungeonObstacle = new DungeonObstacle(this, new Vector2(3.0f, 7));
        dungeonObstacle.setPosition(17, 11);
        getObstacles().add(dungeonObstacle);

        Obstacle farmObstacle = new FarmObstacle(this, new Vector2(5, 4.5f));
        farmObstacle.setPosition(25, 34);
        getObstacles().add(farmObstacle);

        Obstacle fountainObstacle = new FountainObstacle(this, 2);
        fountainObstacle.setPosition(33, 40);
        getObstacles().add(fountainObstacle);

        Obstacle roadSignObstacle = new RoadSignObstacle(this, new Vector2(1.2f, 1.5f));
        roadSignObstacle.setPosition(12, 46);
        getObstacles().add(roadSignObstacle);

        Obstacle tavernObstacle = new TavernObstacle(this, 5);
        tavernObstacle.setPosition(42, 38);
        getObstacles().add(tavernObstacle);

        Wall outskirtsTransitionWall = new OutskirtsTransitionWall(this, new Vector2(0.5f, 10));
        outskirtsTransitionWall.setPosition(7, 40);
        getObstacles().add(outskirtsTransitionWall);
    }

    @Override
    protected void initEffects() {
    }

    @Override
    protected void initSensors() {
        Sensor choboExplorationSensor = new ChoboExplorationSensor(this, new Vector2(10, 0.5f));
        choboExplorationSensor.setPosition(42, 25);

        Sensor dungeonExplorationSensor = new DungeonExplorationSensor(this, new Vector2(10, 0.5f));
        dungeonExplorationSensor.setPosition(10, 20);

        Sensor outskirtsTransitionSensor = new OutskirtsTransitionSensor(this, new Vector2(0.5f, 10));
        outskirtsTransitionSensor.setPosition(8, 40);
    }
}
