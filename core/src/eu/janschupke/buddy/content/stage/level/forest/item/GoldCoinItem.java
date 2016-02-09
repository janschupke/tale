package eu.janschupke.buddy.content.stage.level.forest.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import eu.janschupke.buddy.content.stage.level.forest.ForestEventHandler;
import eu.janschupke.buddy.framework.base.entity.Item;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;
import eu.janschupke.buddy.framework.base.exception.NoHudException;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.world.BaseWorld;
import eu.janschupke.buddy.framework.util.Utility;

/**
 * Gold coin item entity.
 */
public class GoldCoinItem extends Item implements Triggerable {
    public GoldCoinItem(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/sprites/items/coin-gold.png")));
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.pickup");
    }

    @Override
    public void engage() {
        try {
            InteractionSwitch.enable(this,
                    ((ForestEventHandler)((GameScreen)world.getScreen()).getLevelEventHandler()).getCoinPickupEvent(),
                    Utility.getHud(world.getScreen().getApp()).getHintTable());
        } catch (NoHudException e) {
            Gdx.app.log("GoldCoinItem#engage", "No HUD problem.");
        }
    }

    @Override
    public void disengage() {
        try {
            InteractionSwitch.disable(Utility.getHud(world.getScreen().getApp()).getHintTable());
        } catch (NoHudException e) {
            Gdx.app.log("GoldCoinItem#disengage", "No HUD problem.");
        }
    }
}
