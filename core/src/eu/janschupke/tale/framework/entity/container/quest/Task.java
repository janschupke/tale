package eu.janschupke.tale.framework.entity.container.quest;

import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.container.DataContainer;
import eu.janschupke.tale.framework.quest.enumeration.TaskStatus;

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
