package eu.janschupke.buddy.content.stage.level.forest.event;

import com.badlogic.gdx.Gdx;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;

/**
 * Event that is triggered by interacting with the coin.
 * @author jan.schupke@gmail.com
 */
public class CoinInteractEvent extends BaseEvent {
    public CoinInteractEvent(final App app) {
        super(app);
        repeatable = true;
    }

    @Override
    public void trigger() {
        if (!canTrigger()) return;
        Gdx.app.debug("CoinInteractEvent#trigger", "Triggering coin interaction");
        InteractionSwitch.getTriggerable().startInteraction(app);
    }
}
