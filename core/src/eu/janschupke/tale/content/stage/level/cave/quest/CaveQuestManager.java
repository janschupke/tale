package eu.janschupke.tale.content.stage.level.cave.quest;

import eu.janschupke.tale.content.stage.level.cave.quest.chain.corpsec.CorpsecQuestChain;
import eu.janschupke.tale.content.stage.level.cave.quest.chain.ville.VilleQuestChain;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.quest.QuestManager;

/**
 * Quest manager for the Cave level.
 *
 * @author jan.schupke@gmail.com
 */
public class CaveQuestManager extends QuestManager {
    private CorpsecQuestChain corpsecQuestChain;
    private VilleQuestChain villeQuestChain;

    public CaveQuestManager(final App app) {
        super(app);

        corpsecQuestChain = new CorpsecQuestChain(app);
        villeQuestChain = new VilleQuestChain(app);
    }

    public CorpsecQuestChain getCorpsecQuestChain() {
        return corpsecQuestChain;
    }

    public VilleQuestChain getVilleQuestChain() {
        return villeQuestChain;
    }
}
