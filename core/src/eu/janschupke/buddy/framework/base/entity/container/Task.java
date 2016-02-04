package eu.janschupke.buddy.framework.base.entity.container;

import eu.janschupke.buddy.framework.App;

/**
 * Specific task within a quest.
 */
public class Task extends DataContainer {
    public enum Status {
        PROGRESS, DONE
    }

    private Status status;
    private String description;

    public Task(final App app, String description) {
        super(app);
        status = Status.PROGRESS;
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
