package eu.janschupke.tale.content.stage.level.settlement.obstacle.dungeon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.content.stage.level.settlement.SettlementEventHandler;
import eu.janschupke.tale.content.stage.level.settlement.obstacle.dungeon.interaction.DungeonInteraction;
import eu.janschupke.tale.framework.entity.Obstacle;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.event.handling.InteractionSwitch;
import eu.janschupke.tale.framework.exception.NoHudException;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.screen.GameScreen;
import eu.janschupke.tale.framework.world.BaseWorld;

/**
 * Dungeon structure.
 *
 * @author jan.schupke@gmail.com
 */
public class DungeonObstacle extends Obstacle implements Triggerable {
    private Interaction interaction;

    public DungeonObstacle(BaseWorld world, Vector2 size) {
        super(world, new Texture(Gdx.files.internal("textures/levels/settlement/terrain/dungeon.png")), size);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        interaction = new DungeonInteraction(world.getScreen().getApp(), this);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((SettlementEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getDungeonInteractionEvent(),
                world.getScreen().getApp());
    }

    @Override
    public void disengage() {
        try {
            endInteraction(world.getScreen().getApp());
            InteractionSwitch.disable(world.getScreen().getApp().getHud().getHintTable());
        } catch (NoHudException e) {
            Gdx.app.log("DungeonObstacle#disengage", "Could not get HUD instance");
        }
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}
