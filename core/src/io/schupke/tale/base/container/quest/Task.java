package io.schupke.tale.base.container.quest;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.DataContainer;
import io.schupke.tale.base.container.quest.enumeration.TaskStatus;

/**
 * Represents a task within a quest.
 * Manages individual quest objectives and completion criteria.
 */
public class Task extends DataContainer {
    private TaskStatus status;
    private String description;

    public Task(final App app, String description) {
        super(app);
        status = TaskStatus.ACTIVE;
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
        app.getGameState().getQuestLog().update();
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
