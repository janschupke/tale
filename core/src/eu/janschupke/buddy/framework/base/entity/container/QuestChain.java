package eu.janschupke.buddy.framework.base.entity.container;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.config.Config;

import java.util.ArrayList;
import java.util.List;

/**
 * Sequence of quests that come up after each other
 * and make up a logical quest line.
 * @author jan.schupke@gmail.com
 */
public abstract class QuestChain extends DataContainer {
    protected List<Quest> quests;
    protected Quest activeQuest;

    public QuestChain(final App app) {
        super(app);
        quests = new ArrayList<>();
        activeQuest = null;
    }

    /**
     * Wires the succession of quests within the chain,
     * sets the first active quest.
     */
    protected void configure() {
        activeQuest = quests.get(0);
        activeQuest.setStatus(Config.TaskStatus.ACTIVE);
    }

    /**
     * Transitions to the next quest. Goes to the first one, if multiple are available.
     */
    protected void transition() {
        transition(0);
    }

    /**
     * Transitions to the specific next quest from the list of options.
     * @param index Quest index within the list of possibilities.
     */
    protected void transition(int index) {
        activeQuest.setStatus(Config.TaskStatus.DONE);
        if (activeQuest.hasTransition()) {
            activeQuest = activeQuest.getTransition(index);
            activeQuest.setStatus(Config.TaskStatus.ACTIVE);
        }
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public Quest getActiveQuest() {
        return activeQuest;
    }

    /**
     * Retrieves the status of given quest chain based on the status
     * of its quests.
     * @return Current quest chain status.
     */
    public Config.TaskStatus getStatus() {
        Config.TaskStatus status = Config.TaskStatus.INIT;

        boolean allNew = true;
        boolean allDone = true;

        for (Quest quest : quests) {
            if (quest.getStatus() == Config.TaskStatus.DONE) {
                allNew = false;
            } else {
                allDone = false;
            }
        }

        if (allDone) {
            status = Config.TaskStatus.DONE;
        } else if (!allNew) {
            status = Config.TaskStatus.ACTIVE;
        }

        return status;
    }
}
