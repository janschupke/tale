package eu.janschupke.buddy.content.stage.level.outskirts.item.varpunen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import eu.janschupke.buddy.content.stage.level.outskirts.OutskirtsEventHandler;
import eu.janschupke.buddy.content.stage.level.outskirts.item.varpunen.interaction.VarpunenNoteInteraction;
import eu.janschupke.buddy.framework.base.entity.Item;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;
import eu.janschupke.buddy.framework.base.exception.NoHudException;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.world.BaseWorld;
import eu.janschupke.buddy.framework.config.enumeration.ItemTags;

/**
 * Varpunen note - lore and quest item.
 *
 * @author jan.schupke@gmail.com
 */
public class VarpunenNoteItem extends Item implements Triggerable {
    private Interaction interaction;

    public VarpunenNoteItem(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/levels/outskirts/items/varpunen-note.png")), ItemTags.OUTSKIRTS_VARPUNEN_NOTE);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        name = world.getScreen().getApp().getLang().get("level.outskirts.item.varpunen-note.name");
        description = world.getScreen().getApp().getLang().get("level.outskirts.item.varpunen-note.description");
        interaction = new VarpunenNoteInteraction(world.getScreen().getApp(), this);
    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((OutskirtsEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getVarpunenInteractionEvent(),
                world.getScreen().getApp());
    }

    @Override
    public void disengage() {
        try {
            endInteraction(world.getScreen().getApp());
            InteractionSwitch.disable(world.getScreen().getApp().getHud().getHintTable());
        } catch (NoHudException e) {
            Gdx.app.log("VarpunenNoteItem#disengage", "No HUD problem");
        }
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}
