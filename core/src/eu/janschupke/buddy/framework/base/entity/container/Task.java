package eu.janschupke.buddy.framework.base.entity.container;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Specific task within a quest.
 */
public class Task extends DataContainer {
    private Config.TaskStatus status;
    private String description;

    public Task(final App app, String description) {
        super(app);
        status = Config.TaskStatus.NEW;
        this.description = description;
    }

    public Config.TaskStatus getStatus() {
        return status;
    }

    public void setStatus(Config.TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return description;
    }
}
