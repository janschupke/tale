package eu.janschupke.buddy.content.ui.hud;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.table.HudTable;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Standard level HUD.
 * @author jan.schupke@gmail.com
 */
public class StandardHud extends HudTable {
    /**
     * States in which the HUD can be.
     */
    public enum State {
        /**
         * Standard control GUI is visible.
         */
        HUD,

        /**
         * Inventory tab is visible.
         */
        INVENTORY,

        /**
         * Event log is visible.
         */
        EVENTS,

        /**
         * Quest log is visible.
         */
        QUESTS
    }

    // Gameplay HUD tables.
    private HudMenuTable topMenuTable;
    private HintTable hintTable;
    private InteractionTable interactionTable;
    private IndicatorTable indicatorTable;

    // Fullscreen tables.
    private InventoryTable inventoryTable;
    private EventLogTable eventLogTable;
    private QuestLogTable questLogTable;

    private State state;

    public StandardHud(final App app) {
        super(app);
        initWidgets();
        addWidgets();
        setListeners();
        state = State.HUD;
    }

    @Override
    public void initWidgets() {
        topMenuTable = new HudMenuTable(app);
        hintTable = new HintTable(app);
        interactionTable = new InteractionTable(app);
        indicatorTable = new IndicatorTable(app);

        inventoryTable = new InventoryTable(app);
        eventLogTable = new EventLogTable(app);
        questLogTable = new QuestLogTable(app);
    }

    @Override
    public void addWidgets() {
        addHud();
    }

    @Override
    public void setListeners() {}

    /**
     * Adds gameplay widgets to the HUD.
     */
    private void addHud() {
        topHudTable.add(topMenuTable).row();
        topHudTable.add(hintTable).expandY().fillY().padTop(Config.HUD_HINT_TOP_PADDING);
        bottomHudTable.add(indicatorTable).bottom();
        bottomHudTable.add(interactionTable).expandX().fillX();
    }

    /**
     * Toggle between event log table and gameplay HUD.
     */
    public void toggleEventLog() {
        topHudTable.clear();
        bottomHudTable.clear();

        if (state != State.EVENTS) {
            topHudTable.add(eventLogTable);
            state = State.EVENTS;
            app.getGameState().getGlobalLevelState().setNewEvent(false);
        } else {
            addHud();
            state = State.HUD;
        }
    }

    /**
     * Toggle between quest log table and gameplay HUD.
     */
    public void toggleQuestLog() {
        topHudTable.clear();
        bottomHudTable.clear();

        if (state != State.QUESTS) {
            topHudTable.add(questLogTable);
            state = State.QUESTS;
            app.getGameState().getGlobalLevelState().setNewQuest(false);
        } else {
            addHud();
            state = State.HUD;
        }
    }

    /**
     * Toggle between inventory table and gameplay HUD.
     */
    public void toggleInventory() {
        topHudTable.clear();
        bottomHudTable.clear();

        if (state != State.INVENTORY) {
            topHudTable.add(inventoryTable);
            state = State.INVENTORY;
            app.getGameState().getGlobalLevelState().setNewItem(false);
        } else {
            addHud();
            state = State.HUD;
        }
    }

    /**
     * Returns current rendering state of the HUD.
     * @return current visible HUD state.
     */
    public State getState() {
        return state;
    }

    /**
     * Closes any fullscreen tab that might be open,
     * and renders the gameplay HUD.
     */
    public void closeTabs() {
        topHudTable.clear();
        bottomHudTable.clear();
        addHud();
        state = State.HUD;
    }

    public InventoryTable getInventoryTable() {
        return inventoryTable;
    }

    public EventLogTable getEventLogTable() {
        return eventLogTable;
    }

    public QuestLogTable getQuestLogTable() {
        return questLogTable;
    }

    public InteractionTable getInteractionTable() {
        return interactionTable;
    }

    public IndicatorTable getIndicatorTable() {
        return indicatorTable;
    }

    public HintTable getHintTable() {
        return hintTable;
    }
}
