package eu.janschupke.buddy.content.stage.level.forest.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import eu.janschupke.buddy.content.stage.level.forest.ForestEventHandler;
import eu.janschupke.buddy.framework.base.entity.Item;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;
import eu.janschupke.buddy.framework.base.exception.NoHudException;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.world.BaseWorld;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Gold coin item entity.
 *
 * @author jan.schupke@gmail.com
 */
public class GoldCoinItem extends Item implements Triggerable {
    private Interaction interaction = new Interaction() {
        @Override
        protected void configure() {
            title = world.getScreen().getApp().getLang().get("level.forest.interaction.coin.title");
            Situation pickupSituation = new PickupSituation();
            situations.add(pickupSituation);
            currentSituation = pickupSituation;
            fallbackSituation = pickupSituation;
        }

        @Override
        public void handle(Decision decision) {
            Gdx.app.debug("Interaction#handle", "Handling gold coin pickup");
            if (decision instanceof PickupSituation.PickupDecision) {
                ((ForestEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getCoinPickupEvent().trigger();
            } else {
                endInteraction(world.getScreen().getApp());
            }
        }
    };

    // ~ Situations.

    private class PickupSituation extends Situation {
        public PickupSituation() {
            super(world.getScreen().getApp().getLang().get("level.forest.interaction.coin.pickup.description"));
            decisions.add(new PickupDecision());
            decisions.add(new IgnoreDecision());
        }

        private class PickupDecision extends Decision {
            public PickupDecision() {
                super(world.getScreen().getApp().getLang().get("level.forest.interaction.coin.pickup.decision.pickup"),
                        Config.Decisions.FOREST_COIN_PICKUP);
            }

            @Override
            protected void configureMetrics() {
                // Does not influence personality.
            }
        }

        private class IgnoreDecision extends Decision {
            public IgnoreDecision() {
                super(world.getScreen().getApp().getLang().get("level.forest.interaction.coin.pickup.decision.ignore"),
                        Config.Decisions.FOREST_COIN_IGNORE);
            }

            @Override
            protected void configureMetrics() {
                // Does not influence personality.
            }
        }
    }

    // ~ Gold Coin Item.

    public GoldCoinItem(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/levels/forest/items/coin-gold.png")), Config.Items.FOREST_GOLD_COIN);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        name = world.getScreen().getApp().getLang().get("level.forest.item.coin.name");
        description = world.getScreen().getApp().getLang().get("level.forest.item.coin.description");
    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((ForestEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getCoinInteractionEvent(),
                world.getScreen().getApp());
    }

    @Override
    public void disengage() {
        try {
            endInteraction(world.getScreen().getApp());
            InteractionSwitch.disable(world.getScreen().getApp().getHud().getHintTable());
        } catch (NoHudException e) {
            Gdx.app.log("GoldCoinItem#disengage", "No HUD problem");
        }
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}
