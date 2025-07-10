package io.schupke.tale.content.stage.level.cave;

import com.badlogic.gdx.math.Vector2;
import io.schupke.tale.base.entity.Sensor;
import io.schupke.tale.base.entity.Unit;
import io.schupke.tale.base.world.TopDownWorld;
import io.schupke.tale.content.config.Config;
import io.schupke.tale.content.entity.PlayerUnit;
import io.schupke.tale.content.stage.level.cave.sensor.CorpsecExplorationSensor;
import io.schupke.tale.content.stage.level.cave.sensor.OutskirtsTransitionSensor;
import io.schupke.tale.content.stage.level.cave.unit.corpsec.CorpsecUnit;
import io.schupke.tale.content.stage.level.cave.unit.ville.VilleUnit;

/**
 * World for the cave level.
 *
 * @author jan.schupke@gmail.com
 */
public class CaveWorld extends TopDownWorld {
    private Unit villeUnit;
    private Unit corpsecUnit;

    public CaveWorld(CaveScreen screen) {
        super("maps/cave.tmx", 32f, screen);
    }

    @Override
    protected void debugReposition() {
        if (!Config.DEBUG_OBJECT_POSITION) {
            return;
        }

        villeUnit.setPosition(getPlayerUnit().getX() - 1, getPlayerUnit().getY() + 1);
        corpsecUnit.setPosition(getPlayerUnit().getX() + 1, getPlayerUnit().getY() + 1);
    }

    @Override
    protected void initPlayer() {
        setSpawnPoint(36, 11);
        setPlayerUnit(new PlayerUnit(this));
        positionPlayerUnit();
    }

    @Override
    protected void initCreatures() {
        villeUnit = new VilleUnit(this);
        villeUnit.setPosition(42, 26);
        getUnits().add(villeUnit);

        corpsecUnit = new CorpsecUnit(this);
        corpsecUnit.setPosition(16, 15);
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
        Sensor corpsecExplorationSensor = new CorpsecExplorationSensor(this, new Vector2(0.5f, 12));
        corpsecExplorationSensor.setPosition(23, 21);

        Sensor outskirtsTransitionSensor = new OutskirtsTransitionSensor(this, new Vector2(5, 0.5f));
        outskirtsTransitionSensor.setPosition(34, 8);
    }
}
