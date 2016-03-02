package eu.janschupke.tale.framework.base.entity.container;

import eu.janschupke.tale.content.config.Config;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.base.entity.container.event.EventLog;
import eu.janschupke.tale.framework.base.entity.container.inventory.Inventory;
import eu.janschupke.tale.framework.base.entity.container.quest.QuestLog;
import eu.janschupke.tale.framework.base.entity.state.GlobalLevelState;
import eu.janschupke.tale.framework.base.screen.GameScreen;

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
    private EventLog eventLog;

    public GameState(final App app) {
        super(app);
        globalLevelState = new GlobalLevelState();
        inventory = new Inventory(app, Config.INVENTORY_CAPACITY);
        questLog = new QuestLog(app);
        eventLog = new EventLog(app);
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

    public EventLog getEventLog() {
        return eventLog;
    }
}
