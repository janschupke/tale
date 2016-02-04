package eu.janschupke.buddy.framework.base.entity.container;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Encapsulation of all player-relevant data containers.
 */
public class CharacterContainer extends DataContainer {
    private Inventory inventory;
    private QuestLog questLog;
    private EventLog eventLog;

    public CharacterContainer(final App app) {
        super(app);

        inventory = new Inventory(app, Config.INVENTORY_CAPACITY);
        questLog = new QuestLog(app);
        eventLog = new EventLog(app);
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
