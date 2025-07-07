package eu.janschupke.tale.content.stage.level.dungeon.item;

import eu.janschupke.tale.base.entity.Item;
import eu.janschupke.tale.base.world.BaseWorld;
import eu.janschupke.tale.content.config.enumeration.ItemTags;

/**
 * Dungeon gate key item.
 *
 * @author jan.schupke@gmail.com
 */
public class GateKeyItem extends Item {
    public GateKeyItem(BaseWorld world) {
        super(world, world.getScreen().getApp().getResourceManager().getTextureHandler().getDungeonGateKeyItemTexture(),
                ItemTags.DUNGEON_GATE_KEY);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        name = world.getScreen().getApp().getLang().get("level.dungeon.item.key.name");
        description = world.getScreen().getApp().getLang().get("level.dungeon.item.key.description");
    }
}
