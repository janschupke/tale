package eu.janschupke.buddy.content.stage.level.forest.quest.chain.intro;

import eu.janschupke.buddy.content.stage.level.forest.quest.chain.intro.quest.coin_delivery.CoinDeliveryQuest;
import eu.janschupke.buddy.content.stage.level.forest.quest.chain.intro.quest.note_delivery.NoteDeliveryQuest;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.container.QuestChain;

/**
 * First tutorial quest chain.
 */
public class IntroQuestChain extends QuestChain {
    public IntroQuestChain(final App app) {
        super(app);
        quests.add(new CoinDeliveryQuest(app));
        quests.add(new NoteDeliveryQuest(app));
    }
}
