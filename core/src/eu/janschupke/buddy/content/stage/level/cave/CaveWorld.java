package eu.janschupke.buddy.content.stage.level.cave;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.content.entity.PlayerUnit;
import eu.janschupke.buddy.content.stage.level.cave.item.JournalItem;
import eu.janschupke.buddy.content.stage.level.cave.obstacle.spring.SpringObstacle;
import eu.janschupke.buddy.content.stage.level.cave.sensor.CorpsecExplorationSensor;
import eu.janschupke.buddy.content.stage.level.cave.sensor.OutskirtsTransitionSensor;
import eu.janschupke.buddy.content.stage.level.cave.unit.corpsec.CorpsecUnit;
import eu.janschupke.buddy.content.stage.level.cave.unit.ville.VilleUnit;
import eu.janschupke.buddy.framework.base.entity.Item;
import eu.janschupke.buddy.framework.base.entity.Obstacle;
import eu.janschupke.buddy.framework.base.entity.Sensor;
import eu.janschupke.buddy.framework.base.entity.Unit;
import eu.janschupke.buddy.framework.base.world.TopDownWorld;

/**
 * World for the cave level.
 *
 * @author jan.schupke@gmail.com
 */
public class CaveWorld extends TopDownWorld {
    public CaveWorld(CaveScreen screen) {
        super("maps/cave.tmx", 32f, screen);
    }

    @Override
    protected void initPlayer() {
        setSpawnPoint(5, 5);
        setPlayerUnit(new PlayerUnit(this));
        positionPlayerUnit();
    }

    @Override
    protected void initCreatures() {
        Unit villeUnit = new VilleUnit(this);
        villeUnit.setPosition(1, 1);
        getUnits().add(villeUnit);

        Unit corpsecUnit = new CorpsecUnit(this);
        corpsecUnit.setPosition(1, 1);
        getUnits().add(corpsecUnit);
    }

    @Override
    protected void initItems() {
        Item journalItem = new JournalItem(this);
        journalItem.setPosition(1, 1);
        getItems().add(journalItem);
    }

    @Override
    protected void initObstacles() {
        Obstacle springObstacle = new SpringObstacle(this, new Vector2(2, 2));
        springObstacle.setPosition(1, 1);
        getObstacles().add(springObstacle);
    }

    @Override
    protected void initEffects() {
    }

    @Override
    protected void initSensors() {
        Sensor corpsecExplorationSensor = new CorpsecExplorationSensor(this, new Vector2(0.5f, 5));
        corpsecExplorationSensor.setPosition(1, 1);

        Sensor outskirtsTransitionSensor = new OutskirtsTransitionSensor(this, new Vector2(0.5f, 5));
        outskirtsTransitionSensor.setPosition(1, 1);
    }
}
