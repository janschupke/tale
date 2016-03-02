package eu.janschupke.buddy.content.stage.level.cave.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import eu.janschupke.buddy.content.config.enumeration.ItemTags;
import eu.janschupke.buddy.framework.base.entity.Item;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

/**
 * Corpsec-s journal item.
 *
 * @author jan.schupke@gmail.com
 */
public class JournalItem extends Item {
    public JournalItem(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/levels/cave/items/journal.png")), ItemTags.CAVE_JOURNAL);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        name = world.getScreen().getApp().getLang().get("level.cave.item.journal.name");
        description = world.getScreen().getApp().getLang().get("level.cave.item.journal.description");
    }
}
