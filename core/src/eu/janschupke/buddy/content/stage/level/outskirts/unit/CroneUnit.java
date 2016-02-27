package eu.janschupke.buddy.content.stage.level.outskirts.unit;

import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.entity.Unit;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.world.BaseWorld;

/**
 * Crone unit object.
 *
 * @author jan.schupke@gmail.com
 */
public class CroneUnit extends Unit implements Triggerable {
    public CroneUnit(BaseWorld world) {
        super(world, null);
    }

    @Override
    protected void initIdleSprites() {

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
