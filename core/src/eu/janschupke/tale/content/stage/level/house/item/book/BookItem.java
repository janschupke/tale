package eu.janschupke.tale.content.stage.level.house.item.book;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import eu.janschupke.tale.content.config.enumeration.ItemTags;
import eu.janschupke.tale.content.stage.level.house.HouseEventHandler;
import eu.janschupke.tale.content.stage.level.house.item.book.interaction.BookInteraction;
import eu.janschupke.tale.framework.entity.Item;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.event.handling.InteractionSwitch;
import eu.janschupke.tale.framework.exception.NoHudException;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.screen.GameScreen;
import eu.janschupke.tale.framework.world.BaseWorld;

/**
 * House book item.
 *
 * @author jan.schupke@gmail.com
 */
public class BookItem extends Item implements Triggerable {
    private Interaction interaction;

    public BookItem(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/levels/house/items/book.png")), ItemTags.HOUSE_BOOK);
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.investigate");
        name = world.getScreen().getApp().getLang().get("level.house.item.book.name");
        description = world.getScreen().getApp().getLang().get("level.house.item.book.description");
        interaction = new BookInteraction(world.getScreen().getApp(), this);
    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((HouseEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getBookInteractionEvent(),
                world.getScreen().getApp());
    }

    @Override
    public void disengage() {
        try {
            endInteraction(world.getScreen().getApp());
            InteractionSwitch.disable(world.getScreen().getApp().getHud().getHintTable());
        } catch (NoHudException e) {
            Gdx.app.log("BookItem#disengage", "Could not get HUD instance");
        }
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}
