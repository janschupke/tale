package eu.janschupke.tale.content.stage.level.outskirts.obstacle.cave;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.content.stage.level.outskirts.event.OutskirtsEventHandler;
import eu.janschupke.tale.content.stage.level.outskirts.obstacle.cave.interaction.CaveInteraction;
import eu.janschupke.tale.framework.entity.Obstacle;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.interaction.InteractionSwitch;
import eu.janschupke.tale.framework.screen.GameScreen;
import eu.janschupke.tale.framework.world.BaseWorld;

/**
 * Cave entrance world obstacle.
 *
 * @author jan.schupke@gmail.com
 */
public class CaveObstacle extends Obstacle implements Triggerable {
    private Interaction interaction;

    public CaveObstacle(BaseWorld world, Vector2 size) {
        super(world, world.getScreen().getApp().getResourceManager().getTextureHandler().getOutskirtsCaveTexture(), size);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        interaction = new CaveInteraction(world.getScreen().getApp(), this);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((OutskirtsEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getCaveInteractionEvent(),
                world.getScreen().getApp());
    }

    @Override
    public void disengage() {
        endInteraction(world.getScreen().getApp());
        InteractionSwitch.disable(world.getScreen().getApp());
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}
