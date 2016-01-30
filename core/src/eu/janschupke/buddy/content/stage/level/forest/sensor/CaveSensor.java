package eu.janschupke.buddy.content.stage.level.forest.sensor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.framework.base.entity.Sensor;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

/**
 * TODO
 */
public class CaveSensor extends Sensor {
    public CaveSensor(BaseWorld world, Vector2 size) {
        super(world, size);
    }

    @Override
    public void engage() {
        Gdx.app.debug("CaveSensor#engage", "Engaged");
    }

    @Override
    public void disengage() {
        Gdx.app.debug("CaveSensor#disengage", "Disengaged");
    }
}
