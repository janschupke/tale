package io.schupke.tale.content.stage.level.dungeon.item.chest;

import com.badlogic.gdx.math.Vector2;
import io.schupke.tale.base.entity.Item;
import io.schupke.tale.base.entity.Triggerable;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.interaction.InteractionSwitch;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.base.world.BaseWorld;
import io.schupke.tale.content.config.enumeration.ItemTags;
import io.schupke.tale.content.stage.level.dungeon.event.DungeonEventHandler;
import io.schupke.tale.content.stage.level.dungeon.item.chest.interaction.ChestInteraction;

/**
 * Dungeon chest item.
 *
 * @author jan.schupke@gmail.com
 */
public class ChestItem extends Item implements Triggerable {
    private Interaction interaction;

    public ChestItem(BaseWorld world) {
        super(world, world.getScreen().getApp().getResourceManager().getTextureHandler().getDungeonChestItemTexture(),
                new Vector2(1, 1), ItemTags.DUNGEON_CHEST);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
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
