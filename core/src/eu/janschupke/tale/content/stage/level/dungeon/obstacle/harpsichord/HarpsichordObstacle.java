package eu.janschupke.tale.content.stage.level.dungeon.obstacle.harpsichord;

import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.base.entity.Obstacle;
import eu.janschupke.tale.base.entity.Triggerable;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.interaction.InteractionSwitch;
import eu.janschupke.tale.base.screen.GameScreen;
import eu.janschupke.tale.base.world.BaseWorld;
import eu.janschupke.tale.content.stage.level.dungeon.event.DungeonEventHandler;
import eu.janschupke.tale.content.stage.level.dungeon.obstacle.harpsichord.interaction.HarpsichordInteraction;

/**
 * Dungeon harpsichord.
 *
 * @author jan.schupke@gmail.com
 */
public class HarpsichordObstacle extends Obstacle implements Triggerable {
    private Interaction interaction;

    public HarpsichordObstacle(BaseWorld world, Vector2 size) {
        super(world, world.getScreen().getApp().getResourceManager().getTextureHandler().getDungeonHarpsichordTexture(), size);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        interaction = new HarpsichordInteraction(world.getScreen().getApp(), this);
        // Facing left.
        sprite.flip(true, false);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((DungeonEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getHarpsichordInteractionEvent(),
                world.getScreen().getApp());
    }

    @Override
    public void disengage() {
        endInteraction(world.getScreen().getApp());
        InteractionSwitch.disable(world.getScreen().getApp());
        world.getScreen().getApp().getResourceManager().getMusicHandler().stopHarpsichord();
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}
