package eu.janschupke.tale.content.stage.level.dungeon.obstacle.room_four_door;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.content.stage.level.dungeon.DungeonEventHandler;
import eu.janschupke.tale.content.stage.level.dungeon.obstacle.room_four_door.interaction.RoomFourDoorInteraction;
import eu.janschupke.tale.framework.base.entity.Obstacle;
import eu.janschupke.tale.framework.base.entity.Triggerable;
import eu.janschupke.tale.framework.base.event.handling.InteractionSwitch;
import eu.janschupke.tale.framework.base.exception.NoHudException;
import eu.janschupke.tale.framework.base.interaction.Interaction;
import eu.janschupke.tale.framework.base.screen.GameScreen;
import eu.janschupke.tale.framework.base.world.BaseWorld;

/**
 * Door of the fourth dungeon room.
 *
 * @author jan.schupke@gmail.com
 */
public class RoomFourDoorObstacle extends Obstacle implements Triggerable {
    private Interaction interaction;

    public RoomFourDoorObstacle(BaseWorld world, Vector2 size) {
        super(world, new Texture(Gdx.files.internal("textures/levels/dungeon/terrain/door-04.png")), size);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        interaction = new RoomFourDoorInteraction(world.getScreen().getApp(), this);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((DungeonEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getRoomFourDoorInteractionEvent(),
                world.getScreen().getApp());
    }

    @Override
    public void disengage() {
        try {
            endInteraction(world.getScreen().getApp());
            InteractionSwitch.disable(world.getScreen().getApp().getHud().getHintTable());
        } catch (NoHudException e) {
            Gdx.app.log("RoomFourDoorObstacle#disengage", "Could not get HUD instance");
        }
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}
