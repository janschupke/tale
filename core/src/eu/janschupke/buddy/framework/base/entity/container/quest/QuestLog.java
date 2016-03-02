package eu.janschupke.buddy.framework.base.entity.container.quest;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.container.DataContainer;

import java.util.ArrayList;
import java.util.List;

/**
 * Log of all currently active or completed quests.
 *
 * @author jan.schupke@gmail.com
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
        setChanged();
        notifyObservers();
    }

    public boolean isEmpty() {
        return questChains.isEmpty();
    }
}
