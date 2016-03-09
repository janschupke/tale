package eu.janschupke.tale.content.stage.level.forest.obstacle;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.content.stage.level.forest.event.ForestEventHandler;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.entity.Wall;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.screen.GameScreen;
import eu.janschupke.tale.framework.world.BaseWorld;

/**
 * Invisible wall that prevents advancement
 * before the initial quest is completed.
 *
 * @author jan.schupke@gmail.com
 */
public class QuestWall extends Wall implements Triggerable {
    public QuestWall(BaseWorld world, Vector2 size) {
        super(world, size);
    }

    @Override
    public void engage() {
        ((ForestEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getQuestWallGeneralEvent().trigger();
    }

    @Override
    public void disengage() {

    }

    @Override
    public Interaction getInteraction() {
        return null;
    }
}
