package io.schupke.tale.base.container;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.inventory.Inventory;
import io.schupke.tale.base.container.message.MessageLog;
import io.schupke.tale.base.container.quest.QuestLog;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.base.state.GlobalLevelState;
import io.schupke.tale.content.config.Config;

/**
 * Manages the current game state and progress.
 * Tracks player progress, settings, and game data.
 */
public class GameState extends DataContainer {
    private GameScreen currentLevel;
    private GlobalLevelState globalLevelState;
    private Inventory inventory;
    private QuestLog questLog;
    private MessageLog messageLog;

    public GameState(final App app) {
        super(app);
        globalLevelState = new GlobalLevelState();
        inventory = new Inventory(app, Config.INVENTORY_CAPACITY);
        questLog = new QuestLog(app);
        messageLog = new MessageLog(app);
    }

    public GameScreen getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(GameScreen currentLevel) {
        this.currentLevel = currentLevel;
    }

    public GlobalLevelState getGlobalLevelState() {
        return globalLevelState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public QuestLog getQuestLog() {
        return questLog;
    }

    public MessageLog getMessageLog() {
        return messageLog;
    }
}
