package eu.janschupke.tale.content.ui.hud;

import eu.janschupke.tale.content.config.Config;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.ui.table.HudTable;

/**
 * Standard level HUD.
 *
 * @author jan.schupke@gmail.com
 */
public class StandardHud extends HudTable {
    // Gameplay HUD tables.
    private HudMenuTable topMenuTable;
    private HintTable hintTable;
    private InteractionTable interactionTable;
    private IndicatorTable indicatorTable;
    // Fullscreen tables.
    private InventoryTable inventoryTable;
    private MessageLogTable messageLogTable;
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
        messageLogTable = new MessageLogTable(app);
        questLogTable = new QuestLogTable(app);
    }

    @Override
    public void addWidgets() {
        addHud();
    }

    @Override
    public void setListeners() {
    }

    /**
     * Adds gameplay widgets to the HUD.
     */
    private void addHud() {
        topHudPanel.add(topMenuTable).row();
        topHudPanel.add(hintTable).expandY().fillY().padTop(Config.HUD_HINT_TOP_PADDING);
        bottomHudPanel.add(indicatorTable).bottom();
        bottomHudPanel.add(interactionTable).expandX().fillX();
    }

    /**
     * Toggle between event log table and gameplay HUD.
     */
    public void toggleEventLog() {
        topHudPanel.clear();
        bottomHudPanel.clear();
        app.getGameState().getGlobalLevelState().setNewEvent(false);

        if (state != State.EVENTS) {
            topHudPanel.add(messageLogTable);
            state = State.EVENTS;
        } else {
            addHud();
            state = State.HUD;
        }
    }

    /**
     * Toggle between quest log table and gameplay HUD.
     */
    public void toggleQuestLog() {
        topHudPanel.clear();
        bottomHudPanel.clear();
        app.getGameState().getGlobalLevelState().setNewQuest(false);

        if (state != State.QUESTS) {
            topHudPanel.add(questLogTable);
            state = State.QUESTS;
        } else {
            addHud();
            state = State.HUD;
        }
    }

    /**
     * Toggle between inventory table and gameplay HUD.
     */
    public void toggleInventory() {
        topHudPanel.clear();
        bottomHudPanel.clear();
        app.getGameState().getGlobalLevelState().setNewItem(false);

        if (state != State.INVENTORY) {
            topHudPanel.add(inventoryTable);
            state = State.INVENTORY;
        } else {
            addHud();
            state = State.HUD;
        }
    }

    /**
     * Returns current rendering state of the HUD.
     *
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
        topHudPanel.clear();
        bottomHudPanel.clear();
        addHud();
        state = State.HUD;
    }

    public InventoryTable getInventoryTable() {
        return inventoryTable;
    }

    public MessageLogTable getMessageLogTable() {
        return messageLogTable;
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
}
