package eu.janschupke.tale.base.container.quest;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.container.DataContainer;
import eu.janschupke.tale.base.container.quest.enumeration.TaskStatus;

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
