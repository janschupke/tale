package eu.janschupke.buddy.framework.base.entity.container;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.config.Config;

import java.util.ArrayList;
import java.util.List;

/**
 * Quest entry.
 */
public class Quest extends DataContainer {
    private Config.TaskStatus status;
    private String description;
    protected List<Task> tasks;

    public Quest(final App app, String description) {
        super(app);
        status = Config.TaskStatus.NEW;
        this.description = description;
        tasks = new ArrayList<>();
    }

    public Config.TaskStatus getStatus() {
        return status;
    }

    public void setStatus(Config.TaskStatus status) {
        this.status = status;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return description;
    }
}
