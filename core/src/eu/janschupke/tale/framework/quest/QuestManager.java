package eu.janschupke.tale.framework.quest;

import com.badlogic.gdx.Gdx;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.quest.QuestChain;

/**
 * Base quest manager for quest handling.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class QuestManager {
    protected App app;

    public QuestManager(final App app) {
        this.app = app;
    }

    public void initQuestChain(QuestChain chain) {
        Gdx.app.debug("QuestManager#initQuestChain", "Initiating quest");
        app.getGameState().getQuestLog().addQuestChain(chain);
    }
}
