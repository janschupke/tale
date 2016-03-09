package eu.janschupke.tale.content.stage.level.outskirts.quest.chain.jack;

import eu.janschupke.tale.content.stage.level.outskirts.quest.chain.jack.quest.dispute.DisputeQuest;
import eu.janschupke.tale.content.stage.level.outskirts.quest.chain.jack.quest.lumber.LumberQuest;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.quest.QuestChain;

/**
 * Jack's quest chain.
 *
 * @author jan.schupke@gmail.com
 */
public class JackQuestChain extends QuestChain {
    public JackQuestChain(final App app) {
        super(app);
        quests.add(new LumberQuest(app));
        quests.add(new DisputeQuest(app));
        configure();
    }

    @Override
    protected void configure() {
        quests.get(0).addTransition(quests.get(1));
        super.configure();
    }
}