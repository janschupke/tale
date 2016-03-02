package eu.janschupke.tale.content.stage.level.settlement.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import eu.janschupke.tale.content.config.enumeration.ItemTags;
import eu.janschupke.tale.framework.entity.Item;
import eu.janschupke.tale.framework.world.BaseWorld;

/**
 * Key for the Smith's house.
 *
 * @author jan.schupke@gmail.com
 */
public class HouseKeyItem extends Item {
    public HouseKeyItem(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/levels/settlement/items/house-key.png")), ItemTags.SETTLEMENT_HOUSE_KEY);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        name = world.getScreen().getApp().getLang().get("level.settlement.item.house-key.name");
        description = world.getScreen().getApp().getLang().get("level.settlement.item.house-key.description");
    }
}
