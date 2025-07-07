package eu.janschupke.tale.content.stage.level.outskirts.quest.chain.crone;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.container.quest.QuestChain;
import eu.janschupke.tale.content.stage.level.outskirts.quest.chain.crone.quest.delivery.DeliveryQuest;

/**
 * Varpunen note quest chain.
 *
 * @author jan.schupke@gmail.com
 */
public class NoteQuestChain extends QuestChain {
    public NoteQuestChain(final App app) {
        super(app);
        quests.add(new DeliveryQuest(app));
        configure();
    }

    @Override
    protected void configure() {
        super.configure();
    }
}
