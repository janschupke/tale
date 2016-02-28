package eu.janschupke.buddy.content.stage.level.outskirts.item.lumber;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import eu.janschupke.buddy.content.stage.level.outskirts.OutskirtsEventHandler;
import eu.janschupke.buddy.content.stage.level.outskirts.item.lumber.interaction.LumberInteraction;
import eu.janschupke.buddy.framework.base.entity.Item;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;
import eu.janschupke.buddy.framework.base.exception.NoHudException;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.world.BaseWorld;
import eu.janschupke.buddy.framework.config.enumeration.ItemTags;

/**
 * Lumber quest item.
 *
 * @author jan.schupke@gmail.com
 */
public class LumberItem extends Item implements Triggerable {
    private Interaction interaction;

    public LumberItem(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/levels/outskirts/items/lumber.png")), ItemTags.OUTSKIRTS_LUMBER);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        name = world.getScreen().getApp().getLang().get("level.outskirts.item.lumber.name");
        description = world.getScreen().getApp().getLang().get("level.outskirts.item.lumber.description");
        interaction = new LumberInteraction(world.getScreen().getApp(), this);
    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((OutskirtsEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getLumberInteractionEvent(),
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
