package eu.janschupke.tale.content.stage.level.settlement.quest.chain.key;

import eu.janschupke.tale.content.stage.level.settlement.quest.chain.key.quest.KeyDeliveryQuest;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.quest.QuestChain;

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
