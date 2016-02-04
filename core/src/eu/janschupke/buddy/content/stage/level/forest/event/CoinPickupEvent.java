package eu.janschupke.buddy.content.stage.level.forest.event;

import com.badlogic.gdx.Gdx;
import eu.janschupke.buddy.content.stage.level.forest.dialog.PickupDialog;
import eu.janschupke.buddy.content.stage.level.forest.item.GoldCoinItem;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;
import eu.janschupke.buddy.framework.base.event.PickupEvent;

/**
 * Event that picks up the coin from the ground.
 */
public class CoinPickupEvent extends PickupEvent {
    private PickupDialog pickupDialog;
    public CoinPickupEvent(final App app) {
        super(app);
        pickupDialog = new PickupDialog(app);
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        item = ((GoldCoinItem)InteractionSwitch.getInteractible());
        Gdx.app.debug("CoinPickupEvent#trigger", "Picking up the coin.");
        super.trigger();
        pickupDialog.show(app.getUi());
    }
}
