package eu.janschupke.tale.content.stage.level.settlement.quest;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.container.quest.QuestManager;
import eu.janschupke.tale.content.stage.level.settlement.quest.chain.key.KeyQuestChain;

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
