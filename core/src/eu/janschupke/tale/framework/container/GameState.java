package eu.janschupke.tale.framework.container;

import eu.janschupke.tale.content.config.Config;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.inventory.Inventory;
import eu.janschupke.tale.framework.container.message.MessageLog;
import eu.janschupke.tale.framework.container.quest.QuestLog;
import eu.janschupke.tale.framework.screen.GameScreen;
import eu.janschupke.tale.framework.state.GlobalLevelState;

/**
 * Encapsulation of all player-relevant data containers.
 *
 * @author jan.schupke@gmail.com
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
