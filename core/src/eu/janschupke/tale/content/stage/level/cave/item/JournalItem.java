package eu.janschupke.tale.content.stage.level.cave.item;

import eu.janschupke.tale.base.entity.Item;
import eu.janschupke.tale.base.world.BaseWorld;
import eu.janschupke.tale.content.config.enumeration.ItemTags;

/**
 * Corpsec-s journal item.
 *
 * @author jan.schupke@gmail.com
 */
public class JournalItem extends Item {
    public JournalItem(BaseWorld world) {
        super(world, world.getScreen().getApp().getResourceManager().getTextureHandler().getCaveJournalItemTexture(), ItemTags.CAVE_JOURNAL);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        name = world.getScreen().getApp().getLang().get("level.cave.item.journal.name");
        description = world.getScreen().getApp().getLang().get("level.cave.item.journal.description");
    }
}
