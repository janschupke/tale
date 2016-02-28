package eu.janschupke.buddy.content.stage.level.dungeon.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import eu.janschupke.buddy.framework.base.entity.Item;
import eu.janschupke.buddy.framework.base.world.BaseWorld;
import eu.janschupke.buddy.framework.config.enumeration.ItemTags;

/**
 * Dungeon poison item.
 *
 * @author jan.schupke@gmail.com
 */
public class PoisonItem extends Item {
    public PoisonItem(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/levels/dungeon/items/poison.png")), ItemTags.DUNGEON_POISON);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        name = world.getScreen().getApp().getLang().get("level.dungeon.item.poison.name");
        description = world.getScreen().getApp().getLang().get("level.dungeon.item.poison.description");
    }
}
