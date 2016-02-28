package eu.janschupke.buddy.content.stage.level.settlement;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.content.entity.PlayerUnit;
import eu.janschupke.buddy.content.stage.level.settlement.item.HouseKeyItem;
import eu.janschupke.buddy.content.stage.level.settlement.obstacle.blacksmith.BlacksmithObstacle;
import eu.janschupke.buddy.content.stage.level.settlement.obstacle.chobo_house.ChoboHouseObstacle;
import eu.janschupke.buddy.content.stage.level.settlement.obstacle.dungeon.DungeonObstacle;
import eu.janschupke.buddy.content.stage.level.settlement.obstacle.farm.FarmObstacle;
import eu.janschupke.buddy.content.stage.level.settlement.obstacle.fountain.FountainObstacle;
import eu.janschupke.buddy.content.stage.level.settlement.obstacle.road_sign.RoadSignObstacle;
import eu.janschupke.buddy.content.stage.level.settlement.obstacle.tavern.TavernObstacle;
import eu.janschupke.buddy.framework.base.entity.Item;
import eu.janschupke.buddy.framework.base.entity.Obstacle;
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
        setSpawnPoint(5, 5);
        setPlayerUnit(new PlayerUnit(this));
        positionPlayerUnit();
    }

    @Override
    protected void initCreatures() {

    }

    @Override
    protected void initItems() {
        Item houseKeyItem = new HouseKeyItem(this);
        houseKeyItem.setPosition(1, 1);
        getItems().add(houseKeyItem);
    }

    @Override
    protected void initObstacles() {
        Obstacle blacksmithObstacle = new BlacksmithObstacle(this, new Vector2(3, 3));
        blacksmithObstacle.setPosition(1, 1);
        getObstacles().add(blacksmithObstacle);

        Obstacle choboHouseObstacle = new ChoboHouseObstacle(this, new Vector2(3, 3));
        choboHouseObstacle.setPosition(1, 1);
        getObstacles().add(choboHouseObstacle);

        Obstacle dungeonObstacle = new DungeonObstacle(this, new Vector2(3, 3));
        dungeonObstacle.setPosition(1, 1);
        getObstacles().add(dungeonObstacle);

        Obstacle farmObstacle = new FarmObstacle(this, new Vector2(3, 3));
        farmObstacle.setPosition(1, 1);
        getObstacles().add(farmObstacle);

        Obstacle fountainObstacle = new FountainObstacle(this, new Vector2(3, 3));
        fountainObstacle.setPosition(1, 1);
        getObstacles().add(fountainObstacle);

        Obstacle roadSignObstacle = new RoadSignObstacle(this, new Vector2(3, 3));
        roadSignObstacle.setPosition(1, 1);
        getObstacles().add(roadSignObstacle);

        Obstacle tavernObstacle = new TavernObstacle(this, new Vector2(3, 3));
        tavernObstacle.setPosition(1, 1);
        getObstacles().add(tavernObstacle);
    }

    @Override
    protected void initEffects() {
    }

    @Override
    protected void initSensors() {

    }
}
