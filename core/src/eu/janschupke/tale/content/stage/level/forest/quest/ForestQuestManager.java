package eu.janschupke.tale.content.stage.level.forest.quest;

import eu.janschupke.tale.content.stage.level.forest.quest.chain.intro.IntroQuestChain;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.quest.QuestManager;

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
