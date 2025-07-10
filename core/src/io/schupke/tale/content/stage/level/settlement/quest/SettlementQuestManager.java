package io.schupke.tale.content.stage.level.settlement.quest;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.quest.QuestManager;
import io.schupke.tale.content.stage.level.settlement.quest.chain.key.KeyQuestChain;

/**
 * Quest manager for the Settlement level.
 *
 * @author jan.schupke@gmail.com
 */
public class SettlementQuestManager extends QuestManager {
    private KeyQuestChain keyQuestChain;

    public SettlementQuestManager(final App app) {
        super(app);
        keyQuestChain = new KeyQuestChain(app);
    }

    public KeyQuestChain getKeyQuestChain() {
        return keyQuestChain;
    }
}
