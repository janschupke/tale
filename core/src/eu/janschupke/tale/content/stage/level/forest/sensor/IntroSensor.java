package eu.janschupke.tale.content.stage.level.forest.sensor;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.content.stage.level.forest.ForestEventHandler;
import eu.janschupke.tale.framework.entity.Sensor;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.screen.GameScreen;
import eu.janschupke.tale.framework.world.BaseWorld;

/**
 * A sensor that is triggered right after the game starts,
 * giving some introduction text through a dialog.
 *
 * @author jan.schupke@gmail.com
 */
public class IntroSensor extends Sensor implements Triggerable {
    public IntroSensor(BaseWorld world, Vector2 size) {
        super(world, size);
    }

    @Override
    public void engage() {
        ((ForestEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getIntroGeneralEvent().trigger();
    }

    @Override
    public void disengage() {

    }

    @Override
    public Interaction getInteraction() {
        return null;
    }
}
