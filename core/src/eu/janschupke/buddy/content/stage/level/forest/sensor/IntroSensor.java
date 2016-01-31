package eu.janschupke.buddy.content.stage.level.forest.sensor;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.content.stage.level.forest.ForestEventHandler;
import eu.janschupke.buddy.framework.base.entity.Interactible;
import eu.janschupke.buddy.framework.base.entity.Sensor;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

/**
 * A sensor that is triggered right after the game starts,
 * giving some introduction text through a dialog.
 */
public class IntroSensor extends Sensor implements Interactible {
    public IntroSensor(BaseWorld world, Vector2 size) {
        super(world, size);
    }

    @Override
    public void engage() {
        ((ForestEventHandler)((GameScreen)world.getScreen()).getLevelEventHandler()).triggerIntro();
    }

    @Override
    public void disengage() {

    }
}
