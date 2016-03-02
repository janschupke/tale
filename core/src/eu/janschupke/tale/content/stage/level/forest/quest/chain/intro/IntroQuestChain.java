package eu.janschupke.tale.content.stage.level.forest.quest.chain.intro;

import eu.janschupke.tale.content.stage.level.forest.quest.chain.intro.quest.coin_delivery.CoinDeliveryQuest;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.container.quest.QuestChain;

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
//        quests.get(0).addTransition(quests.get(1));
    }
}
