package eu.janschupke.buddy.content.stage.level.settlement.obstacle.tavern;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import eu.janschupke.buddy.content.stage.level.settlement.SettlementEventHandler;
import eu.janschupke.buddy.content.stage.level.settlement.obstacle.tavern.interaction.TavernInteraction;
import eu.janschupke.buddy.framework.base.entity.Obstacle;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;
import eu.janschupke.buddy.framework.base.exception.NoHudException;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

/**
 * Tavern building.
 *
 * @author jan.schupke@gmail.com
 */
public class TavernObstacle extends Obstacle implements Triggerable {
    private Interaction interaction;

    public TavernObstacle(BaseWorld world, Vector2 size) {
        super(world, new Texture(Gdx.files.internal("textures/levels/settlement/terrain/tavern.png")), size);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        interaction = new TavernInteraction(world.getScreen().getApp(), this);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((SettlementEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getTavernInteractionEvent(),
                world.getScreen().getApp());
    }

    @Override
    public void disengage() {
        try {
            endInteraction(world.getScreen().getApp());
            InteractionSwitch.disable(world.getScreen().getApp().getHud().getHintTable());
        } catch (NoHudException e) {
            Gdx.app.log("TavernObstacle#disengage", "Could not get HUD instance");
        }
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}