package eu.janschupke.buddy.framework.base.entity.container;

import eu.janschupke.buddy.framework.App;

import java.util.ArrayList;
import java.util.List;

/**
 * Log of all currently active or completed quests.
 */
public class QuestLog extends DataContainer {
    private List<QuestChain> questChains;

    public QuestLog(final App app) {
        super(app);
        questChains = new ArrayList<>();
    }

    public List<QuestChain> getQuestChains() {
        return questChains;
    }

    public void addQuestChain(QuestChain chain) {
        questChains.add(chain);
    }
}
