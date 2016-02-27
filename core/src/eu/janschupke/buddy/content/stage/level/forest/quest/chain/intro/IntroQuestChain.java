package eu.janschupke.buddy.content.stage.level.forest.quest.chain.intro;

import eu.janschupke.buddy.content.stage.level.forest.quest.chain.intro.quest.coin_delivery.CoinDeliveryQuest;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.container.QuestChain;

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
