package eu.janschupke.tale.content.stage.level.dungeon.item.book;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import eu.janschupke.tale.content.config.enumeration.ItemTags;
import eu.janschupke.tale.content.stage.level.dungeon.event.DungeonEventHandler;
import eu.janschupke.tale.content.stage.level.dungeon.item.book.interaction.BookInteraction;
import eu.janschupke.tale.framework.entity.Item;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.interaction.InteractionSwitch;
import eu.janschupke.tale.framework.screen.GameScreen;
import eu.janschupke.tale.framework.world.BaseWorld;

/**
 * First book item.
 *
 * @author jan.schupke@gmail.com
 */
public class BookItem extends Item implements Triggerable {
    private Interaction interaction;

    public BookItem(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/levels/dungeon/items/book.png")), ItemTags.DUNGEON_BOOK);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        name = world.getScreen().getApp().getLang().get("level.dungeon.item.book-one.name");
        description = world.getScreen().getApp().getLang().get("level.dungeon.item.book-one.description");
        interaction = new BookInteraction(world.getScreen().getApp(), this);
    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((DungeonEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getBookInteractionEvent(),
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
