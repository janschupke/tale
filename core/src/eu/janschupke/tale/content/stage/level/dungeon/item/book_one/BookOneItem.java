package eu.janschupke.tale.content.stage.level.dungeon.item.book_one;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import eu.janschupke.tale.content.config.enumeration.ItemTags;
import eu.janschupke.tale.content.stage.level.dungeon.DungeonEventHandler;
import eu.janschupke.tale.content.stage.level.dungeon.item.book_one.interaction.BookOneInteraction;
import eu.janschupke.tale.framework.entity.Item;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.event.handling.InteractionSwitch;
import eu.janschupke.tale.framework.exception.NoHudException;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.screen.GameScreen;
import eu.janschupke.tale.framework.world.BaseWorld;

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
            Gdx.app.log("BookOneItem#disengage", "Could not get HUD instance");
        }
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}
