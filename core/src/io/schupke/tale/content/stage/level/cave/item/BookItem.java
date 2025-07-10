package io.schupke.tale.content.stage.level.cave.item;

import io.schupke.tale.base.entity.Item;
import io.schupke.tale.base.world.BaseWorld;
import io.schupke.tale.content.config.enumeration.ItemTags;

/**
 * Jack's book item
 *
 * @author jan.schupke@gmail.com
 */
public class BookItem extends Item {
    public BookItem(BaseWorld world) {
        super(world, world.getScreen().getApp().getResourceManager().getTextureHandler().getCaveBookItemTexture(), ItemTags.CAVE_BOOK);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        name = world.getScreen().getApp().getLang().get("level.cave.item.book.name");
        description = world.getScreen().getApp().getLang().get("level.cave.item.book.description");
    }
}
