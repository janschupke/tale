package eu.janschupke.tale.content.stage.level.cave;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.content.entity.PlayerUnit;
import eu.janschupke.tale.content.stage.level.cave.sensor.CorpsecExplorationSensor;
import eu.janschupke.tale.content.stage.level.cave.sensor.OutskirtsTransitionSensor;
import eu.janschupke.tale.content.stage.level.cave.unit.corpsec.CorpsecUnit;
import eu.janschupke.tale.content.stage.level.cave.unit.ville.VilleUnit;
import eu.janschupke.tale.framework.entity.Sensor;
import eu.janschupke.tale.framework.entity.Unit;
import eu.janschupke.tale.framework.world.TopDownWorld;

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
        setSpawnPoint(32, 8);
        setPlayerUnit(new PlayerUnit(this));
        positionPlayerUnit();
    }

    @Override
    protected void initCreatures() {
        Unit villeUnit = new VilleUnit(this);
        villeUnit.setPosition(39, 39);
        getUnits().add(villeUnit);

        Unit corpsecUnit = new CorpsecUnit(this);
        corpsecUnit.setPosition(11, 22);
        getUnits().add(corpsecUnit);
    }

    @Override
    protected void initItems() {
    }

    @Override
    protected void initObstacles() {

    }

    @Override
    protected void initEffects() {
    }

    @Override
    protected void initSensors() {
        Sensor corpsecExplorationSensor = new CorpsecExplorationSensor(this, new Vector2(12, 0.5f));
        corpsecExplorationSensor.setPosition(4, 30);

        Sensor outskirtsTransitionSensor = new OutskirtsTransitionSensor(this, new Vector2(5, 0.5f));
        outskirtsTransitionSensor.setPosition(30, 5);
    }
}
