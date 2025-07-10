package io.schupke.tale.content.stage.level.forest.quest;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.quest.QuestManager;
import io.schupke.tale.content.stage.level.forest.quest.chain.intro.IntroQuestChain;

/**
 * Quest manager for the forest level.
 *
 * @author jan.schupke@gmail.com
 */
public class ForestQuestManager extends QuestManager {
    /**
     * Tutorial quest chain.
     */
    private IntroQuestChain introQuestChain;

    public ForestQuestManager(final App app) {
        super(app);
        introQuestChain = new IntroQuestChain(app);
    }

    public IntroQuestChain getIntroQuestChain() {
        return introQuestChain;
    }
}
