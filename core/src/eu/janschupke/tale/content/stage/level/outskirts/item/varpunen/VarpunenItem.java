package eu.janschupke.tale.content.stage.level.outskirts.item.varpunen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import eu.janschupke.tale.content.config.enumeration.ItemTags;
import eu.janschupke.tale.content.stage.level.outskirts.event.OutskirtsEventHandler;
import eu.janschupke.tale.content.stage.level.outskirts.item.varpunen.interaction.VarpunenInteraction;
import eu.janschupke.tale.framework.entity.Item;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.interaction.InteractionSwitch;
import eu.janschupke.tale.framework.screen.GameScreen;
import eu.janschupke.tale.framework.world.BaseWorld;

/**
 * Varpunen note - lore and quest item.
 *
 * @author jan.schupke@gmail.com
 */
public class VarpunenItem extends Item implements Triggerable {
    private Interaction interaction;

    public VarpunenItem(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/levels/outskirts/items/varpunen.png")), ItemTags.OUTSKIRTS_VARPUNEN_NOTE);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        name = world.getScreen().getApp().getLang().get("level.outskirts.item.varpunen.name");
        description = world.getScreen().getApp().getLang().get("level.outskirts.item.varpunen.description");
        interaction = new VarpunenInteraction(world.getScreen().getApp(), this);
    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((OutskirtsEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getVarpunenInteractionEvent(),
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
