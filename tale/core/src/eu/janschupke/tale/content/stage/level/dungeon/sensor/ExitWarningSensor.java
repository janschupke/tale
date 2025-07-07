package eu.janschupke.tale.content.stage.level.dungeon.sensor;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.base.entity.Sensor;
import eu.janschupke.tale.base.entity.Triggerable;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.screen.GameScreen;
import eu.janschupke.tale.base.world.BaseWorld;
import eu.janschupke.tale.content.stage.level.dungeon.event.DungeonEventHandler;

/**
 * Warning about the approach of the game end.
 *
 * @author jan.schupke@gmail.com
 */
public class ExitWarningSensor extends Sensor implements Triggerable {
    public ExitWarningSensor(BaseWorld world, Vector2 size) {
        super(world, size);
    }

    @Override
    public void engage() {
        ((DungeonEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getExitWarningEvent().trigger();
    }

    @Override
    public void disengage() {

    }

    @Override
    public Interaction getInteraction() {
        return null;
    }
}
