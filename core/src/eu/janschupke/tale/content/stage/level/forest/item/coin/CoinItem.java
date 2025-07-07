package eu.janschupke.tale.content.stage.level.forest.item.coin;

import eu.janschupke.tale.base.entity.Item;
import eu.janschupke.tale.base.entity.Triggerable;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.interaction.InteractionSwitch;
import eu.janschupke.tale.base.screen.GameScreen;
import eu.janschupke.tale.base.world.BaseWorld;
import eu.janschupke.tale.content.config.enumeration.ItemTags;
import eu.janschupke.tale.content.stage.level.forest.event.ForestEventHandler;
import eu.janschupke.tale.content.stage.level.forest.item.coin.interaction.CoinInteraction;

/**
 * Gold coin item entity.
 *
 * @author jan.schupke@gmail.com
 */
public class CoinItem extends Item implements Triggerable {
    private Interaction interaction;

    public CoinItem(BaseWorld world) {
        super(world, world.getScreen().getApp().getResourceManager().getTextureHandler().getForestCoinTexture(), ItemTags.FOREST_COIN);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        name = world.getScreen().getApp().getLang().get("level.forest.item.coin.name");
        description = world.getScreen().getApp().getLang().get("level.forest.item.coin.description");
        interaction = new CoinInteraction(world.getScreen().getApp(), this);
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
