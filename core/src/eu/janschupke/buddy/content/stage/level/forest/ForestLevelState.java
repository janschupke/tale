package eu.janschupke.buddy.content.stage.level.forest;

import eu.janschupke.buddy.framework.base.screen.LevelState;

/**
 * Level state for the forest level.
 *
 * @author jan.schupke@gmail.com
 */
public class ForestLevelState extends LevelState {
    private boolean conPickedUp;

    public boolean isConPickedUp() {
        return conPickedUp;
    }

    public void setConPickedUp(boolean conPickedUp) {
        this.conPickedUp = conPickedUp;
    }
}
