package eu.janschupke.buddy.framework.base.entity.container;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.config.Config;

import java.util.ArrayList;
import java.util.List;

/**
 * Sequence of quests that come up after each other
 * and make up a logical quest line.
 */
public class QuestChain extends DataContainer {
    protected List<Quest> quests;

    public QuestChain(final App app) {
        super(app);
        quests = new ArrayList<>();
    }

    public List<Quest> getQuests() {
        return quests;
    }

    // TODO: ?
    public Config.TaskStatus getStatus() {
        Config.TaskStatus status = Config.TaskStatus.NEW;

        boolean allNew = true;
        boolean allDone = true;

        for (Quest quest : quests) {
            if (quest.getStatus() != Config.TaskStatus.NEW) {
                allNew = false;
            }

            if (quest.getStatus() != Config.TaskStatus.DONE) {
                allDone = false;
            }
        }

        if (allDone) {
            status = Config.TaskStatus.DONE;
        } else if (!allNew) {
            status = Config.TaskStatus.PROGRESS;
        }

        return status;
    }
}
