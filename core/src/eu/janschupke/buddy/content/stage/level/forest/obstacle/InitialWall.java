package eu.janschupke.buddy.content.stage.level.forest.obstacle;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.content.stage.level.forest.ForestEventHandler;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.entity.Wall;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

/**
 * A wall obstacle that doesn't let the player continue
 * until he picks up the initial item.
 *
 * @author jan.schupke@gmail.com
 */
public class InitialWall extends Wall implements Triggerable {
    public InitialWall(BaseWorld world, Vector2 size) {
        super(world, size);
    }

    @Override
    public void engage() {
        ((ForestEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getInitialWallEvent().trigger();
    }

    @Override
    public void disengage() {

    }

    @Override
    public Interaction getInteraction() {
        return null;
    }
}
