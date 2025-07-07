package eu.janschupke.tale.content.stage.level.forest.obstacle;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.base.entity.Triggerable;
import eu.janschupke.tale.base.entity.Wall;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.screen.GameScreen;
import eu.janschupke.tale.base.world.BaseWorld;
import eu.janschupke.tale.content.stage.level.forest.event.ForestEventHandler;

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
