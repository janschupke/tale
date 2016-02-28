package eu.janschupke.buddy.content.stage.level.outskirts.obstacle.jack_house;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.content.stage.level.outskirts.OutskirtsEventHandler;
import eu.janschupke.buddy.content.stage.level.outskirts.obstacle.jack_house.interaction.JackHouseInteraction;
import eu.janschupke.buddy.framework.base.entity.Obstacle;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;
import eu.janschupke.buddy.framework.base.exception.NoHudException;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

/**
 * Jack's house obstacle object.
 *
 * @author jan.schupke@gmail.com
 */
public class JackHouseObstacle extends Obstacle implements Triggerable {
    private Interaction interaction;

    public JackHouseObstacle(BaseWorld world, Vector2 size) {
        super(world, new Texture(Gdx.files.internal("textures/levels/outskirts/terrain/jack-house.png")), size);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        interaction = new JackHouseInteraction(world.getScreen().getApp(), this);
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
        try {
            endInteraction(world.getScreen().getApp());
            InteractionSwitch.disable(world.getScreen().getApp().getHud().getHintTable());
        } catch (NoHudException e) {
            Gdx.app.log("GoldCoinItem#disengage", "No HUD problem");
        }
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}