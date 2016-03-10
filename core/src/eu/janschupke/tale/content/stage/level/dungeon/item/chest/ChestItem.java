package eu.janschupke.tale.content.stage.level.dungeon.item.chest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import eu.janschupke.tale.content.config.enumeration.ItemTags;
import eu.janschupke.tale.content.stage.level.dungeon.event.DungeonEventHandler;
import eu.janschupke.tale.content.stage.level.dungeon.item.chest.interaction.ChestInteraction;
import eu.janschupke.tale.framework.entity.Item;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.interaction.InteractionSwitch;
import eu.janschupke.tale.framework.screen.GameScreen;
import eu.janschupke.tale.framework.world.BaseWorld;

/**
 * Dungeon chest item.
 *
 * @author jan.schupke@gmail.com
 */
public class ChestItem extends Item implements Triggerable {
    private Interaction interaction;

    public ChestItem(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/levels/dungeon/items/chest.png")),
                new Vector2(1, 1), ItemTags.DUNGEON_CHEST);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        name = world.getScreen().getApp().getLang().get("level.dungeon.item.chest.name");
        description = world.getScreen().getApp().getLang().get("level.dungeon.item.chest.description");
        interaction = new ChestInteraction(world.getScreen().getApp(), this);
    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((DungeonEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getChestInteractionEvent(),
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
