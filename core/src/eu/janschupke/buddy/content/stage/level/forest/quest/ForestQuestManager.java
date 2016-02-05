package eu.janschupke.buddy.content.stage.level.forest.quest;

import eu.janschupke.buddy.content.stage.level.forest.quest.chain.intro.IntroQuestChain;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.quest.QuestManager;

/**
 * Quest manager for the forest level.
 */
public class ForestQuestManager extends QuestManager {
    private IntroQuestChain introQuestChain;

    public ForestQuestManager(final App app) {
        super(app);
        introQuestChain = new IntroQuestChain(app);
    }

    public IntroQuestChain getIntroQuestChain() {
        return introQuestChain;
    }
}
