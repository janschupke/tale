package eu.janschupke.tale.content.stage.level.forest.item.coin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import eu.janschupke.tale.content.config.enumeration.ItemTags;
import eu.janschupke.tale.content.stage.level.forest.ForestEventHandler;
import eu.janschupke.tale.content.stage.level.forest.item.coin.interaction.GoldCoinInteraction;
import eu.janschupke.tale.framework.entity.Item;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.interaction.InteractionSwitch;
import eu.janschupke.tale.framework.screen.GameScreen;
import eu.janschupke.tale.framework.world.BaseWorld;

/**
 * Gold coin item entity.
 *
 * @author jan.schupke@gmail.com
 */
public class GoldCoinItem extends Item implements Triggerable {
    private Interaction interaction;

    public GoldCoinItem(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/levels/forest/items/coin-gold.png")), ItemTags.FOREST_GOLD_COIN);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        name = world.getScreen().getApp().getLang().get("level.forest.item.coin.name");
        description = world.getScreen().getApp().getLang().get("level.forest.item.coin.description");
        interaction = new GoldCoinInteraction(world.getScreen().getApp(), this);
    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((ForestEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getCoinInteractionEvent(),
                world.getScreen().getApp());
    }

    @Override
    public void disengage() {
        endInteraction(world.getScreen().getApp());
        InteractionSwitch.disable(world.getScreen().getApp());
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}
