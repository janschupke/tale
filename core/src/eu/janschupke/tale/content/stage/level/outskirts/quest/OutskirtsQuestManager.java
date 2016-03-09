package eu.janschupke.tale.content.stage.level.outskirts.quest;

import eu.janschupke.tale.content.stage.level.outskirts.quest.chain.crone.NoteQuestChain;
import eu.janschupke.tale.content.stage.level.outskirts.quest.chain.jack.JackQuestChain;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.quest.QuestManager;

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
