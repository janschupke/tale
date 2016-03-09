package eu.janschupke.tale.content.stage.level.outskirts;

import eu.janschupke.tale.framework.state.LevelState;

/**
 * Level state for the Outskirts level.
 *
 * @author jan.schupke@gmail.com
 */
public class OutskirtsLevelState extends LevelState {
    private boolean disputeQuestOffered;

    public boolean isDisputeQuestOffered() {
        return disputeQuestOffered;
    }

    public void setDisputeQuestOffered(boolean disputeQuestOffered) {
        this.disputeQuestOffered = disputeQuestOffered;
    }
}
