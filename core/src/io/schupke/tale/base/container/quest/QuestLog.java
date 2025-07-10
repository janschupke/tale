package io.schupke.tale.base.container.quest;

import java.util.ArrayList;
import java.util.List;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.DataContainer;

/**
 * Manages the player's quest log.
 * Tracks active and completed quests.
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
        update();
    }

    public boolean isEmpty() {
        return questChains.isEmpty();
    }
}
