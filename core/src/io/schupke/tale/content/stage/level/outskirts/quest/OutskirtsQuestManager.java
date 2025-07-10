package io.schupke.tale.content.stage.level.outskirts.quest;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.quest.QuestManager;
import io.schupke.tale.content.stage.level.outskirts.quest.chain.crone.NoteQuestChain;
import io.schupke.tale.content.stage.level.outskirts.quest.chain.jack.JackQuestChain;

/**
 * Quest manager for the Outskirts level.
 *
 * @author jan.schupke@gmail.com
 */
public class OutskirtsQuestManager extends QuestManager {
    private NoteQuestChain noteQuestChain;
    private JackQuestChain jackQuestChain;

    public OutskirtsQuestManager(final App app) {
        super(app);

        noteQuestChain = new NoteQuestChain(app);
        jackQuestChain = new JackQuestChain(app);
    }

    public NoteQuestChain getNoteQuestChain() {
        return noteQuestChain;
    }

    public JackQuestChain getJackQuestChain() {
        return jackQuestChain;
    }
}
