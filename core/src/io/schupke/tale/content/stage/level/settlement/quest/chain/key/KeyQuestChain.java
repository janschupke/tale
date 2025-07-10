package io.schupke.tale.content.stage.level.settlement.quest.chain.key;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.quest.QuestChain;
import io.schupke.tale.content.stage.level.settlement.quest.chain.key.quest.KeyDeliveryQuest;

/**
 * Settlement key delivery quest chain.
 *
 * @author jan.schupke@gmail.com
 */
public class KeyQuestChain extends QuestChain {
    public KeyQuestChain(final App app) {
        super(app);
        quests.add(new KeyDeliveryQuest(app));
        configure();
    }

    @Override
    protected void configure() {
        super.configure();
    }
}
