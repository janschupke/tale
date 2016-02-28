package eu.janschupke.buddy.content.stage.level.outskirts.item;

import eu.janschupke.buddy.framework.base.entity.Item;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.world.BaseWorld;
import eu.janschupke.buddy.framework.config.enumeration.ItemTags;

/**
 * Lumber quest item.
 *
 * @author jan.schupke@gmail.com
 */
public class LumberItem extends Item implements Triggerable {
    public LumberItem(BaseWorld world) {
        super(world, null, ItemTags.OUTSKIRTS_LUMBER);
    }

    @Override
    public void engage() {

    }

    @Override
    public void disengage() {

    }

    @Override
    public Interaction getInteraction() {
        return null;
    }
}
