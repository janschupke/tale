package io.schupke.tale.content.stage.level.outskirts.obstacle.jack_house;

import com.badlogic.gdx.math.Vector2;
import io.schupke.tale.base.entity.Obstacle;
import io.schupke.tale.base.entity.Triggerable;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.interaction.InteractionSwitch;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.base.world.BaseWorld;
import io.schupke.tale.content.stage.level.outskirts.event.OutskirtsEventHandler;
import io.schupke.tale.content.stage.level.outskirts.obstacle.jack_house.interaction.JackHouseInteraction;

/**
 * Jack's house obstacle object.
 *
 * @author jan.schupke@gmail.com
 */
public class JackHouseObstacle extends Obstacle implements Triggerable {
    private Interaction interaction;

    public JackHouseObstacle(BaseWorld world, Vector2 size) {
        super(world, world.getScreen().getApp().getResourceManager().getTextureHandler().getOutskirtsJackHouseTexture(), size);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        interaction = new JackHouseInteraction(world.getScreen().getApp(), this);
        sprite.flip(true, false);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((OutskirtsEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getJackHouseInteractionEvent(),
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
