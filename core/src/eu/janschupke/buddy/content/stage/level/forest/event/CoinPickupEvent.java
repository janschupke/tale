package eu.janschupke.buddy.content.stage.level.forest.event;

import com.badlogic.gdx.Gdx;
import eu.janschupke.buddy.content.stage.level.forest.ForestScreen;
import eu.janschupke.buddy.content.stage.level.forest.item.GoldCoinItem;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;

/**
 * Event that picks up the coin from the ground.
 */
public class CoinPickupEvent extends BaseEvent {
    public CoinPickupEvent(final App app) {
        super(app);
        repeatable = false;
    }

    @Override
    public void trigger() {
        super.trigger();
        Gdx.app.debug("CoinPickupEvent#trigger", "Picking up the coin.");
        GoldCoinItem item = ((GoldCoinItem)InteractionSwitch.getInteractible());
        ((ForestScreen) app.getScreen()).getWorld().removeItem(item);

        // TODO: add to inventory
    }

}
