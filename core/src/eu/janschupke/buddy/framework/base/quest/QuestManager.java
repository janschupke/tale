package eu.janschupke.buddy.framework.base.quest;

import com.badlogic.gdx.Gdx;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.container.QuestChain;
import eu.janschupke.buddy.framework.base.exception.NoHudException;
import eu.janschupke.buddy.framework.util.Utility;

/**
 * Base quest manager for quest handling.
 */
public abstract class QuestManager {
    protected App app;

    public QuestManager(final App app) {
        this.app = app;
    }

    public void initQuestChain(QuestChain chain) {
        Gdx.app.debug("QuestManager#initQuestChain", "Initiating quest");
        app.getGameState().getQuestLog().addQuestChain(chain);

        try {
            Utility.getHud(app).getQuestLogTable().update();
        } catch (NoHudException e) {
            Gdx.app.log("QuestManager#initQuestChain", "No HUD problem.");
        }
    }
}
