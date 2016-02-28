package eu.janschupke.buddy.content.stage.level.dungeon.item.book_one;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import eu.janschupke.buddy.content.stage.level.dungeon.DungeonEventHandler;
import eu.janschupke.buddy.content.stage.level.dungeon.item.book_one.interaction.BookOneInteraction;
import eu.janschupke.buddy.framework.base.entity.Item;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;
import eu.janschupke.buddy.framework.base.exception.NoHudException;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.world.BaseWorld;
import eu.janschupke.buddy.framework.config.enumeration.ItemTags;

/**
 * First book item.
 *
 * @author jan.schupke@gmail.com
 */
public class BookOneItem extends Item implements Triggerable {
    private Interaction interaction;

    public BookOneItem(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/levels/dungeon/items/book-01.png")), ItemTags.DUNGEON_BOOK_ONE);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        name = world.getScreen().getApp().getLang().get("level.dungeon.item.book-one.name");
        description = world.getScreen().getApp().getLang().get("level.dungeon.item.book-one.description");
        interaction = new BookOneInteraction(world.getScreen().getApp(), this);
    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((DungeonEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getBookOneInteractionEvent(),
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
