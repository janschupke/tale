package eu.janschupke.tale.content.stage.level.cave.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import eu.janschupke.tale.content.config.enumeration.ItemTags;
import eu.janschupke.tale.framework.entity.Item;
import eu.janschupke.tale.framework.world.BaseWorld;

/**
 * Jack's book item
 *
 * @author jan.schupke@gmail.com
 */
public class BookItem extends Item {
    public BookItem(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/levels/cave/items/book.png")), ItemTags.CAVE_BOOK);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        name = world.getScreen().getApp().getLang().get("level.cave.item.book.name");
        description = world.getScreen().getApp().getLang().get("level.cave.item.book.description");
    }
}
