package eu.janschupke.buddy.framework.base.entity.container;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.config.Config;

import java.util.ArrayList;
import java.util.List;

/**
 * Quest entry.
 *
 * @author jan.schupke@gmail.com
 */
public class Quest extends DataContainer {
    protected List<Task> tasks;
    protected List<Quest> transitions;
    private Config.TaskStatus status;
    private String name;
    private String description;

    public Quest(final App app, String name, String description) {
        super(app);
        status = Config.TaskStatus.INIT;
        this.name = name;
        this.description = description;
        tasks = new ArrayList<>();
        transitions = new ArrayList<>();
    }

    public Config.TaskStatus getStatus() {
        return status;
    }

    public void setStatus(Config.TaskStatus status) {
        this.status = status;
        setChanged();
        notifyObservers();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTransition(Quest quest) {
        transitions.add(quest);
    }

    public boolean hasTransition() {
        return !transitions.isEmpty();
    }

    public Quest getTransition() {
        return transitions.get(0);
    }

    public Quest getTransition(int index) {
        return transitions.get(index);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name;
    }
}
