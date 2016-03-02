package eu.janschupke.buddy.framework.base.entity.container.quest;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.container.DataContainer;
import eu.janschupke.buddy.framework.config.enumeration.TaskStatus;

/**
 * Specific task within a quest.
 *
 * @author jan.schupke@gmail.com
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
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
