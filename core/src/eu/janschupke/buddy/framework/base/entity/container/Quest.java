package eu.janschupke.buddy.framework.base.entity.container;

import eu.janschupke.buddy.framework.App;

import java.util.ArrayList;
import java.util.List;

/**
 * Quest entry.
 */
public class Quest extends DataContainer {
    public enum Status {
        PROGRESS, DONE
    }

    private Status status;
    private String description;
    private List<Task> tasks;

    public Quest(final App app, String description) {
        super(app);
        status = Status.PROGRESS;
        this.description = description;
        tasks = new ArrayList<>();
    }

    public Status getStatus() {
        return status;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return description;
    }
}
