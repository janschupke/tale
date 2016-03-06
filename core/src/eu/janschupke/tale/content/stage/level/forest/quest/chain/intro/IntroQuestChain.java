package eu.janschupke.tale.content.stage.level.forest.quest.chain.intro;

import eu.janschupke.tale.content.stage.level.forest.quest.chain.intro.quest.coin_delivery.CoinDeliveryQuest;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.quest.QuestChain;

/**
 * First tutorial quest chain.
 *
 * @author jan.schupke@gmail.com
 */
public class IntroQuestChain extends QuestChain {
    public IntroQuestChain(final App app) {
        super(app);
        quests.add(new CoinDeliveryQuest(app));
        configure();
    }

    @Override
    protected void configure() {
        super.configure();
    }
}
