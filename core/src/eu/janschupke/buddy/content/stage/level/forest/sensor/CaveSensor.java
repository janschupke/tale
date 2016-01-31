package eu.janschupke.buddy.content.stage.level.forest.sensor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.framework.base.entity.Interactible;
import eu.janschupke.buddy.framework.base.entity.Sensor;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

/**
 * A sensor that triggers cave lore in the tutorial area.
 */
public class CaveSensor extends Sensor implements Interactible {
    public CaveSensor(BaseWorld world, Vector2 size) {
        super(world, size);
        body.setUserData(this);
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
