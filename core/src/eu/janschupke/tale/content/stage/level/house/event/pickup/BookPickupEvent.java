package eu.janschupke.tale.content.stage.level.house.event.pickup;

import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.PickupEvent;
import eu.janschupke.tale.framework.screen.BaseScreen;

/**
 * Pickup event for the book.
 *
 * @author jan.schupke@gmail.com
 */
public class BookPickupEvent extends PickupEvent {
    public BookPickupEvent(final App app) {
        // TODO
        super(app, "TODO");
    }

    @Override
    protected void updateMessages() {

    }

    @Override
    protected void updateQuests() {

    }

    @Override
    protected void updateGameState() {
        app.getGameLog().addEntry(GameEventTags.HOUSE_PICKUP_BOOK, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
