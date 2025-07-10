package io.schupke.tale.base.container.quest;

import java.util.ArrayList;
import java.util.List;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.DataContainer;
import io.schupke.tale.base.container.quest.enumeration.TaskStatus;

/**
 * Represents a chain of related quests.
 * Manages quest dependencies and progression.
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
        activeQuest.setStatus(TaskStatus.ACTIVE);
    }

    /**
     * Transitions to the next quest. Goes to the first one, if multiple are available.
     */
    public final void transition() {
        transition(0);
    }

    /**
     * Transitions to the specific next quest from the list of options.
     *
     * @param index Quest index within the list of possibilities.
     */
    public final void transition(int index) {
        activeQuest.setStatus(TaskStatus.DONE);
        if (activeQuest.hasTransition()) {
            activeQuest = activeQuest.getTransition(index);
            activeQuest.setStatus(TaskStatus.ACTIVE);
        }
        app.getGameState().getQuestLog().update();
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
     *
     * @return Current quest chain status.
     */
    public TaskStatus getStatus() {
        TaskStatus status = TaskStatus.INIT;

        boolean allNew = true;
        boolean allDone = true;

        for (Quest quest : quests) {
            if (quest.getStatus() == TaskStatus.DONE) {
                allNew = false;
            } else {
                allDone = false;
            }
        }

        if (allDone) {
            status = TaskStatus.DONE;
        } else if (!allNew) {
            status = TaskStatus.ACTIVE;
        }

        return status;
    }
}
