package eu.janschupke.tale.content.stage.level.cave.quest.chain.ville;

import eu.janschupke.tale.content.stage.level.cave.quest.chain.ville.quest.message.MessageQuest;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.quest.QuestChain;

/**
 * Ville quest chain.
 *
 * @author jan.schupke@gmail.com
 */
public class VilleQuestChain extends QuestChain {
    public VilleQuestChain(final App app) {
        super(app);
        quests.add(new MessageQuest(app));
        configure();
    }

    @Override
    protected void configure() {
        super.configure();
    }
}
