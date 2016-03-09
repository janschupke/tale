package eu.janschupke.tale.content.stage.level.outskirts.event.pickup;

import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.PickupEvent;
import eu.janschupke.tale.framework.screen.BaseScreen;

/**
 * Event for the lumber item pickup.
 *
 * @author jan.schupke@gmail.com
 */
public class LumberPickupEvent extends PickupEvent {
    public LumberPickupEvent(final App app) {
        super(app);
    }

    @Override
    protected void updateMessages() {

    }

    @Override
    protected void updateQuests() {

    }

    @Override
    protected void updateGameState() {
        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_PICKUP_LUMBER, ((BaseScreen) app.getScreen()).getTag());
        // TODO: enable lumber decision
        // TODO: if quest exists, set task status
    }

    @Override
    protected void updateInteractions() {

    }
}
