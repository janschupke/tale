package eu.janschupke.tale.content.stage.level.dungeon.obstacle.room_two_door;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.content.stage.level.dungeon.DungeonEventHandler;
import eu.janschupke.tale.content.stage.level.dungeon.obstacle.room_two_door.interaction.RoomTwoDoorInteraction;
import eu.janschupke.tale.framework.base.entity.Obstacle;
import eu.janschupke.tale.framework.base.entity.Triggerable;
import eu.janschupke.tale.framework.base.event.handling.InteractionSwitch;
import eu.janschupke.tale.framework.base.exception.NoHudException;
import eu.janschupke.tale.framework.base.interaction.Interaction;
import eu.janschupke.tale.framework.base.screen.GameScreen;
import eu.janschupke.tale.framework.base.world.BaseWorld;

/**
 * Door of the second dungeon room.
 *
 * @author jan.schupke@gmail.com
 */
public class RoomTwoDoorObstacle extends Obstacle implements Triggerable {
    private Interaction interaction;

    public RoomTwoDoorObstacle(BaseWorld world, Vector2 size) {
        super(world, new Texture(Gdx.files.internal("textures/levels/dungeon/terrain/door-02.png")), size);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        interaction = new RoomTwoDoorInteraction(world.getScreen().getApp(), this);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((DungeonEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getRoomTwoDoorInteractionEvent(),
                world.getScreen().getApp());
    }

    @Override
    public void disengage() {
        try {
            endInteraction(world.getScreen().getApp());
            InteractionSwitch.disable(world.getScreen().getApp().getHud().getHintTable());
        } catch (NoHudException e) {
            Gdx.app.log("RoomTwoDoorObstacle#disengage", "Could not get HUD instance");
        }
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}
