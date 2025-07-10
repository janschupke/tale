package io.schupke.tale.content.stage.level.outskirts.item.lumber;

import com.badlogic.gdx.math.Vector2;
import io.schupke.tale.base.entity.Item;
import io.schupke.tale.base.entity.Triggerable;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.interaction.InteractionSwitch;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.base.world.BaseWorld;
import io.schupke.tale.content.config.enumeration.ItemTags;
import io.schupke.tale.content.stage.level.outskirts.event.OutskirtsEventHandler;
import io.schupke.tale.content.stage.level.outskirts.item.lumber.interaction.LumberInteraction;

/**
 * Lumber quest item.
 *
 * @author jan.schupke@gmail.com
 */
public class LumberItem extends Item implements Triggerable {
    private Interaction interaction;

    public LumberItem(BaseWorld world) {
        super(world, world.getScreen().getApp().getResourceManager().getTextureHandler().getOutskirtsLumberItemTexture(),
                new Vector2(0.8f, 0.4f), ItemTags.OUTSKIRTS_LUMBER);
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
        endInteraction(world.getScreen().getApp());
        InteractionSwitch.disable(world.getScreen().getApp());
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}
