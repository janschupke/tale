package io.schupke.tale.content.stage.level.outskirts.quest.chain.crone;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.quest.QuestChain;
import io.schupke.tale.content.stage.level.outskirts.quest.chain.crone.quest.delivery.DeliveryQuest;

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
