package eu.janschupke.tale.content.stage.level.cave.obstacle.spring;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.content.stage.level.cave.CaveEventHandler;
import eu.janschupke.tale.content.stage.level.cave.obstacle.spring.interaction.SpringInteraction;
import eu.janschupke.tale.framework.entity.Obstacle;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.event.handling.InteractionSwitch;
import eu.janschupke.tale.framework.exception.NoHudException;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.screen.GameScreen;
import eu.janschupke.tale.framework.world.BaseWorld;

/**
 * Cave spring obstacle.
 *
 * @author jan.schupke@gmail.com
 */
public class SpringObstacle extends Obstacle implements Triggerable {
    private Interaction interaction;

    public SpringObstacle(BaseWorld world, Vector2 size) {
        super(world, new Texture(Gdx.files.internal("textures/levels/cave/terrain/spring.png")), size);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        interaction = new SpringInteraction(world.getScreen().getApp(), this);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((CaveEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getSpringInteractionEvent(),
                world.getScreen().getApp());
    }

    @Override
    public void disengage() {
        try {
            endInteraction(world.getScreen().getApp());
            InteractionSwitch.disable(world.getScreen().getApp().getHud().getHintTable());
        } catch (NoHudException e) {
            Gdx.app.log("SpringObstacle#disengage", "Could not get HUD instance");
        }
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}
