package eu.janschupke.buddy.content.ui.hud;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.table.HudTable;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Standard level HUD.
 */
public class StandardHud extends HudTable {
    public enum State {
        HUD, INVENTORY, EVENTS, QUESTS
    }

    private HudMenuTable topMenuTable;
    private HintTable hintTable;
    private InteractionTable interactionTable;
    private IndicatorTable indicatorTable;

    // Fullscreen tables
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
    public void setListeners() {
    }

    private void addHud() {
        topHudTable.add(topMenuTable).row();
        topHudTable.add(hintTable).expandY().fillY().padTop(Config.HUD_HINT_TOP_PADDING);
        bottomHudTable.add(indicatorTable).bottom().padRight(Config.HUD_INNER_PADDING);
        bottomHudTable.add(interactionTable).expandX().fillX();
    }

    public void toggleEventLog() {
        topHudTable.clear();
        bottomHudTable.clear();

        if (state != State.EVENTS) {
            topHudTable.add(eventLogTable);
            state = State.EVENTS;
        } else {
            addHud();
            state = State.HUD;
        }
    }

    public void toggleQuestLog() {
        topHudTable.clear();
        bottomHudTable.clear();

        if (state != State.QUESTS) {
            topHudTable.add(questLogTable);
            state = State.QUESTS;
        } else {
            addHud();
            state = State.HUD;
        }
    }

    public void toggleInventory() {
        topHudTable.clear();
        bottomHudTable.clear();

        if (state != State.INVENTORY) {
            topHudTable.add(inventoryTable);
            state = State.INVENTORY;
        } else {
            addHud();
            state = State.HUD;
        }
    }

    public State getState() {
        return state;
    }

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
