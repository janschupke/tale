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
import eu.janschupke.buddy.framework.base.interaction.NoMoreSituationsException;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.world.BaseWorld;
import eu.janschupke.buddy.framework.util.Utility;

/**
 * Gold coin item entity.
 */
public class GoldCoinItem extends Item implements Triggerable {
    private class PickupSituation extends Situation {
        private class PickupDecision extends Decision {
            public PickupDecision() {
                super("Decision: pickup");
            }
        }

        private class IgnoreDecision extends Decision {
            public IgnoreDecision() {
                super("Decision: ignore");
            }
        }

        public PickupSituation() {
            super("TODO: description");
            decisions.add(new PickupDecision());
            decisions.add(new IgnoreDecision());
        }

        @Override
        public Situation getFollowing(Decision decision) throws NoMoreSituationsException {
            // Nothing follows.
            throw new NoMoreSituationsException();
        }
    }

    // TODO
    private Interaction interaction = new Interaction() {
        @Override
        protected void configure() {
            title = "TODO: interaction title";
            Situation pickupSituation = new PickupSituation();
            situations.add(pickupSituation);
            currentSituation = pickupSituation;
            fallbackSituation = pickupSituation;
        }

        @Override
        public void handle(Decision decision) {
            Gdx.app.debug("Interaction#handle", "Handling gold coin pickup");
            if (decision instanceof PickupSituation.PickupDecision) {
                // TODO: do pickup
                 ((ForestEventHandler)((GameScreen)world.getScreen()).getLevelEventHandler()).getCoinPickupEvent().trigger();
            } else {
                endInteraction(world.getScreen().getApp());
            }
        }
    };

    public GoldCoinItem(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/sprites/items/coin-gold.png")));
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        name = world.getScreen().getApp().getLang().get("level.forest.item.coin.name");
        description = world.getScreen().getApp().getLang().get("level.forest.item.coin.description");
    }

    @Override
    public void engage() {
        try {
            InteractionSwitch.enable(this,
                    ((ForestEventHandler)((GameScreen)world.getScreen()).getLevelEventHandler()).getCoinInteractEvent(),
                    Utility.getHud(world.getScreen().getApp()).getHintTable());
        } catch (NoHudException e) {
            Gdx.app.log("GoldCoinItem#engage", "No HUD problem.");
        }
    }

    @Override
    public void disengage() {
        try {
            endInteraction(world.getScreen().getApp());
            InteractionSwitch.disable(Utility.getHud(world.getScreen().getApp()).getHintTable());
        } catch (NoHudException e) {
            Gdx.app.log("GoldCoinItem#disengage", "No HUD problem.");
        }
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}
