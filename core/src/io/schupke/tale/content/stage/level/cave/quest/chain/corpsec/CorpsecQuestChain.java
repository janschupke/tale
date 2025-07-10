package io.schupke.tale.content.stage.level.cave.quest.chain.corpsec;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.quest.QuestChain;
import io.schupke.tale.content.stage.level.cave.quest.chain.corpsec.quest.investigate.InvestigateQuest;

/**
 * Corpsec investigation quest chain.
 *
 * @author jan.schupke@gmail.com
 */
public class CorpsecQuestChain extends QuestChain {
    public CorpsecQuestChain(final App app) {
        super(app);
        quests.add(new InvestigateQuest(app));
        configure();
    }

    @Override
    protected void configure() {
        super.configure();
    }
}
