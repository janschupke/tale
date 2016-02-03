package eu.janschupke.buddy.content.ui.hud;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.table.HudTable;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Standard level HUD.
 */
public class StandardHud extends HudTable {
    private HudMenuTable topMenuTable;
    private InventoryTable inventoryTable;
    private EventLogTable eventLogTable;
    private QuestLogTable questLogTable;
    private InteractionTable interactionTable;

    public StandardHud(final App app) {
        super(app);

        initWidgets();
        addWidgets();
        setListeners();
    }

    @Override
    public void initWidgets() {
        topMenuTable = new HudMenuTable(app);
        inventoryTable = new InventoryTable(app);
        eventLogTable = new EventLogTable(app);
        questLogTable = new QuestLogTable(app);
        interactionTable = new InteractionTable(app);
    }

    @Override
    public void addWidgets() {
        Table middleTable = new Table();
        middleTable.add(interactionTable).expand().fill().row();
        middleTable.add(inventoryTable);

        // TODO: mock data
        eventLogTable.addMessage("Dummy event");
        eventLogTable.addMessage("asdfghjkuytrew vfgtuy sdfgt");

        topHudTable.add(topMenuTable);
        bottomHudTable.add(eventLogTable).expandY().fill().bottom().width(Config.HUD_SIDE_PANE_WIDTH);
        bottomHudTable.add(middleTable).expand().fill();
        bottomHudTable.add(questLogTable).expandY().fill().bottom().width(Config.HUD_SIDE_PANE_WIDTH);
    }

    @Override
    public void setListeners() {
    }

    public HudMenuTable getTopMenuTable() {
        return topMenuTable;
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
}
