package io.schupke.tale.content.stage.level.cave.quest;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.quest.QuestManager;
import io.schupke.tale.content.stage.level.cave.quest.chain.corpsec.CorpsecQuestChain;

/**
 * Quest manager for the Cave level.
 *
 * @author jan.schupke@gmail.com
 */
public class CaveQuestManager extends QuestManager {
    private CorpsecQuestChain corpsecQuestChain;

    public CaveQuestManager(final App app) {
        super(app);

        corpsecQuestChain = new CorpsecQuestChain(app);
    }

    public CorpsecQuestChain getCorpsecQuestChain() {
        return corpsecQuestChain;
    }
}
