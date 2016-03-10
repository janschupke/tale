package eu.janschupke.tale.content.stage.level.dungeon.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import eu.janschupke.tale.content.config.enumeration.ItemTags;
import eu.janschupke.tale.framework.entity.Item;
import eu.janschupke.tale.framework.world.BaseWorld;

/**
 * Dungeon gate key item.
 *
 * @author jan.schupke@gmail.com
 */
public class GateKeyItem extends Item {
    public GateKeyItem(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/levels/dungeon/items/key.png")), ItemTags.DUNGEON_GATE_KEY);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        name = world.getScreen().getApp().getLang().get("level.dungeon.item.key.name");
        description = world.getScreen().getApp().getLang().get("level.dungeon.item.key.description");
    }
}
