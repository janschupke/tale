package io.schupke.tale.base.container.quest;

import com.badlogic.gdx.Gdx;

import io.schupke.tale.base.App;

/**
 * Manages all quest-related functionality.
 * Handles quest creation, tracking, and completion.
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
