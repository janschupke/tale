package eu.janschupke.buddy.content.stage.level.forest.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import eu.janschupke.buddy.framework.base.entity.Interactible;
import eu.janschupke.buddy.framework.base.entity.Item;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

/**
 * Gold coin item entity.
 */
public class GoldCoinItem extends Item implements Interactible {
    public GoldCoinItem(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/sprites/items/coin-gold.png")));
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void engage() {

    }

    @Override
    public void disengage() {

    }
}
