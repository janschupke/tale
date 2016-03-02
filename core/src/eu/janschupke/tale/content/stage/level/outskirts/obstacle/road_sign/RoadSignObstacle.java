package eu.janschupke.tale.content.stage.level.outskirts.obstacle.road_sign;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.content.stage.level.outskirts.OutskirtsEventHandler;
import eu.janschupke.tale.content.stage.level.outskirts.obstacle.road_sign.interaction.RoadSignInteraction;
import eu.janschupke.tale.framework.base.entity.Obstacle;
import eu.janschupke.tale.framework.base.entity.Triggerable;
import eu.janschupke.tale.framework.base.event.handling.InteractionSwitch;
import eu.janschupke.tale.framework.base.exception.NoHudException;
import eu.janschupke.tale.framework.base.interaction.Interaction;
import eu.janschupke.tale.framework.base.screen.GameScreen;
import eu.janschupke.tale.framework.base.world.BaseWorld;

/**
 * Crossroad sign obstacle.
 *
 * @author jan.schupke@gmail.com
 */
public class RoadSignObstacle extends Obstacle implements Triggerable {
    private Interaction interaction;

    public RoadSignObstacle(BaseWorld world, Vector2 size) {
        super(world, new Texture(Gdx.files.internal("textures/levels/outskirts/terrain/road-sign.png")), size);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        interaction = new RoadSignInteraction(world.getScreen().getApp(), this);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((OutskirtsEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getRoadSignInteractionEvent(),
                world.getScreen().getApp());
    }

    @Override
    public void disengage() {
        try {
            endInteraction(world.getScreen().getApp());
            InteractionSwitch.disable(world.getScreen().getApp().getHud().getHintTable());
        } catch (NoHudException e) {
            Gdx.app.log("RoadSignObstacle#disengage", "Could not get HUD instance");
        }
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}
