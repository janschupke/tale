package eu.janschupke.buddy.content.stage.level.forest;

import eu.janschupke.buddy.framework.base.screen.LevelState;

/**
 * Level state for the forest level.
 *
 * @author jan.schupke@gmail.com
 */
public class ForestLevelState extends LevelState {
    private boolean coinPickedUp;
    private boolean coinDelivered;

    public boolean isCoinPickedUp() {
        return coinPickedUp;
    }

    public void setCoinPickedUp(boolean coinPickedUp) {
        this.coinPickedUp = coinPickedUp;
    }

    public boolean isCoinDelivered() {
        return coinDelivered;
    }

    public void setCoinDelivered(boolean coinDelivered) {
        this.coinDelivered = coinDelivered;
    }
}
