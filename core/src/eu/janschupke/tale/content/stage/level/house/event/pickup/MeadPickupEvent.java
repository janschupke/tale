package eu.janschupke.tale.content.stage.level.house.event.pickup;

import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.PickupEvent;
import eu.janschupke.tale.framework.screen.BaseScreen;

/**
 * Pickup event for the mead item.
 *
 * @author jan.schupke@gmail.com
 */
public class MeadPickupEvent extends PickupEvent {
    public MeadPickupEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.HOUSE_PICKUP_MEAD, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
