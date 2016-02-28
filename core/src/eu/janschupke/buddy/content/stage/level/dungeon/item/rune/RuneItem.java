package eu.janschupke.buddy.content.stage.level.dungeon.item.rune;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import eu.janschupke.buddy.content.stage.level.dungeon.DungeonEventHandler;
import eu.janschupke.buddy.content.stage.level.dungeon.item.rune.interaction.RuneInteraction;
import eu.janschupke.buddy.framework.base.entity.Item;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;
import eu.janschupke.buddy.framework.base.exception.NoHudException;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.world.BaseWorld;
import eu.janschupke.buddy.framework.config.enumeration.ItemTags;

/**
 * Dungeon rune item.
 *
 * @author jan.schupke@gmail.com
 */
public class RuneItem extends Item implements Triggerable {
    private Interaction interaction;

    public RuneItem(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/levels/dungeon/items/rune.png")), ItemTags.DUNGEON_RUNE);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        name = world.getScreen().getApp().getLang().get("level.dungeon.item.rune.name");
        description = world.getScreen().getApp().getLang().get("level.dungeon.item.rune.description");
        interaction = new RuneInteraction(world.getScreen().getApp(), this);
    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((DungeonEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getRuneInteractionEvent(),
                world.getScreen().getApp());
    }

    @Override
    public void disengage() {
        try {
            endInteraction(world.getScreen().getApp());
            InteractionSwitch.disable(world.getScreen().getApp().getHud().getHintTable());
        } catch (NoHudException e) {
            Gdx.app.log("RuneItem#disengage", "Could not get HUD instance");
        }
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}
