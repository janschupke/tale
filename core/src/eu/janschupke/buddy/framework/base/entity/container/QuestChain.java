package eu.janschupke.buddy.framework.base.entity.container;

import eu.janschupke.buddy.framework.App;

import java.util.ArrayList;
import java.util.List;

/**
 * Sequence of quests that come up after each other
 * and make up a logical quest line.
 */
public class QuestChain extends DataContainer {
    private List<Quest> quests;

    public QuestChain(final App app) {
        super(app);
        quests = new ArrayList<>();
    }

    public List<Quest> getQuests() {
        return quests;
    }
}
