package eu.janschupke.buddy.framework.base.quest;

import com.badlogic.gdx.Gdx;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.container.QuestChain;

/**
 * Base quest manager for quest handling.
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
