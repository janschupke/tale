package eu.janschupke.tale.content.stage.level.settlement.item;

import eu.janschupke.tale.base.entity.Item;
import eu.janschupke.tale.base.world.BaseWorld;
import eu.janschupke.tale.content.config.enumeration.ItemTags;

/**
 * Key for the Smith's house.
 *
 * @author jan.schupke@gmail.com
 */
public class HouseKeyItem extends Item {
    public HouseKeyItem(BaseWorld world) {
        super(world, world.getScreen().getApp().getResourceManager().getTextureHandler().getSettlementHouseKeyTexture(),
                ItemTags.SETTLEMENT_HOUSE_KEY);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        name = world.getScreen().getApp().getLang().get("level.settlement.item.house-key.name");
        description = world.getScreen().getApp().getLang().get("level.settlement.item.house-key.description");
    }
}
