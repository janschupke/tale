package eu.janschupke.tale.base.container.quest;

import java.util.ArrayList;
import java.util.List;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.container.DataContainer;
import eu.janschupke.tale.base.container.quest.enumeration.TaskStatus;

/**
 * Represents a quest in the game.
 * Manages quest objectives, progress, and completion.
 */
public class Quest extends DataContainer {
    protected List<Task> tasks;
    protected List<Quest> transitions;
    private TaskStatus status;
    private final String name;
    private final String description;

    public Quest(final App app, String name, String description) {
        super(app);
        status = TaskStatus.INIT;
        this.name = name;
        this.description = description;
        tasks = new ArrayList<>();
        transitions = new ArrayList<>();
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
        app.getGameState().getQuestLog().update();
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
