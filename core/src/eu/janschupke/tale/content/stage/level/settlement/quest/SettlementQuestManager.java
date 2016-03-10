package eu.janschupke.tale.content.stage.level.settlement.quest;

import eu.janschupke.tale.content.stage.level.settlement.quest.chain.key.KeyQuestChain;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.quest.QuestManager;

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
