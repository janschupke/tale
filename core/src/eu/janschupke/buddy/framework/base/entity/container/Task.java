package eu.janschupke.buddy.framework.base.entity.container;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Specific task within a quest.
 * @author jan.schupke@gmail.com
 */
public class Task extends DataContainer {
    private Config.TaskStatus status;
    private String description;

    public Task(final App app, String description) {
        super(app);
        status = Config.TaskStatus.ACTIVE;
        this.description = description;
    }

    public Config.TaskStatus getStatus() {
        return status;
    }

    public void setStatus(Config.TaskStatus status) {
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
