package eu.janschupke.buddy.content.stage.level.outskirts.item;

import eu.janschupke.buddy.framework.base.entity.Item;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

/**
 * Varpunen note - lore and quest item.
 *
 * @author jan.schupke@gmail.com
 */
public class VarpunenNoteItem extends Item implements Triggerable {
    public VarpunenNoteItem(BaseWorld world) {
        super(world, null);
    }

    @Override
    public void engage() {

    }

    @Override
    public void disengage() {

    }

    @Override
    public String getInteractionHint() {
        return null;
    }

    @Override
    public Interaction getInteraction() {
        return null;
    }
}
