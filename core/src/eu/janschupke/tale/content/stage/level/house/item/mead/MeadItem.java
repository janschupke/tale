package eu.janschupke.tale.content.stage.level.house.item.mead;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import eu.janschupke.tale.content.config.enumeration.ItemTags;
import eu.janschupke.tale.content.stage.level.house.HouseEventHandler;
import eu.janschupke.tale.content.stage.level.house.item.mead.interaction.MeadInteraction;
import eu.janschupke.tale.framework.entity.Item;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.exception.NoHudException;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.interaction.InteractionSwitch;
import eu.janschupke.tale.framework.screen.GameScreen;
import eu.janschupke.tale.framework.world.BaseWorld;

/**
 * House mead item.
 *
 * @author jan.schupke@gmail.com
 */
public class MeadItem extends Item implements Triggerable {
    private Interaction interaction;

    public MeadItem(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/levels/house/items/mead.png")), ItemTags.HOUSE_MEAD);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        name = world.getScreen().getApp().getLang().get("level.house.item.mead.name");
        description = world.getScreen().getApp().getLang().get("level.house.item.mead.description");
        interaction = new MeadInteraction(world.getScreen().getApp(), this);
    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((HouseEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getMeadInteractionEvent(),
                world.getScreen().getApp());
    }

    @Override
    public void disengage() {
        try {
            endInteraction(world.getScreen().getApp());
            InteractionSwitch.disable(world.getScreen().getApp().getHud().getHintTable());
        } catch (NoHudException e) {
            Gdx.app.log("MeadItem#disengage", "Could not get HUD instance");
        }
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}
