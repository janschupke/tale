package io.schupke.tale.content.stage.level.forest.quest.chain.intro;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.quest.QuestChain;
import io.schupke.tale.content.stage.level.forest.quest.chain.intro.quest.delivery.DeliveryQuest;

/**
 * First tutorial quest chain.
 *
 * @author jan.schupke@gmail.com
 */
public class IntroQuestChain extends QuestChain {
    public IntroQuestChain(final App app) {
        super(app);
        quests.add(new DeliveryQuest(app));
        configure();
    }

    @Override
    protected void configure() {
        super.configure();
    }
}
