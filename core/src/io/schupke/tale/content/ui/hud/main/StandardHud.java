package io.schupke.tale.content.ui.hud.main;

import io.schupke.tale.base.App;
import io.schupke.tale.base.ui.table.HudTable;
import io.schupke.tale.content.config.Config;
import io.schupke.tale.content.ui.hud.tab.InventoryTable;
import io.schupke.tale.content.ui.hud.tab.MessageLogTable;
import io.schupke.tale.content.ui.hud.tab.QuestLogTable;

/**
 * Standard HUD implementation following HUD.md specifications.
 * Provides the complete HUD hierarchy with proper layout management.
 */
public class StandardHud extends HudTable implements io.schupke.tale.base.ui.UserInterface {
    
    /**
     * HUD states as specified in HUD.md
     */
    public enum State {
        HUD,           // Normal gameplay interface
        INVENTORY,     // Inventory overlay active
        EVENTS,        // Message log overlay active
        QUESTS         // Quest log overlay active
    }
    
    // Gameplay HUD components (as per HUD.md)
    private HudMenuTable topMenuTable;
    private HintTable hintTable;
    private InteractionTable interactionTable;
    private IndicatorTable indicatorTable;
    
    // Fullscreen overlay components (as per HUD.md)
    private InventoryTable inventoryTable;
    private MessageLogTable messageLogTable;
    private QuestLogTable questLogTable;
    
    private State currentState;
    
    public StandardHud(final App app) {
        super(app);
        
        // Initialize state
        currentState = State.HUD;
        
        // Initialize all HUD components
        initComponents();
        
        // Setup the initial HUD layout
        setupGameplayHud();
    }
    
    /**
     * Initialize all HUD components as specified in HUD.md
     */
    private void initComponents() {
        // Create gameplay HUD components
        topMenuTable = new HudMenuTable(app);
        hintTable = new HintTable(app);
        interactionTable = new InteractionTable(app);
        indicatorTable = new IndicatorTable(app);
        
        // Create fullscreen overlay components
        inventoryTable = new InventoryTable(app);
        messageLogTable = new MessageLogTable(app);
        questLogTable = new QuestLogTable(app);
    }
    
    /**
     * Setup the gameplay HUD layout as specified in HUD.md
     */
    private void setupGameplayHud() {
        // Clear existing layout
        topHudPanel.clear();
        bottomHudPanel.clear();
        
        // Top panel: Menu buttons and hint (as per HUD.md)
        topHudPanel.add(topMenuTable).row();
        topHudPanel.add(hintTable).expandY().fillY().padTop(Config.HUD_HINT_TOP_PADDING);
        
        // Bottom panel: Indicators and interactions (as per HUD.md)
        bottomHudPanel.add(indicatorTable).bottom();
        bottomHudPanel.add(interactionTable).expandX().fillX();
    }
    
    /**
     * Toggle event log visibility
     */
    public void toggleEventLog() {
        // Clear current state
        topHudPanel.clear();
        bottomHudPanel.clear();
        
        // Update state
        app.getGameState().getGlobalLevelState().setNewEvent(false);
        
        if (currentState != State.EVENTS) {
            // Show message log
            topHudPanel.add(messageLogTable);
            currentState = State.EVENTS;
        } else {
            // Return to gameplay HUD
            setupGameplayHud();
            currentState = State.HUD;
            app.getEventHandler().handleHintMessage();
        }
    }
    
    /**
     * Toggle quest log visibility
     */
    public void toggleQuestLog() {
        // Clear current state
        topHudPanel.clear();
        bottomHudPanel.clear();
        
        // Update state
        app.getGameState().getGlobalLevelState().setNewQuest(false);
        
        if (currentState != State.QUESTS) {
            // Show quest log
            topHudPanel.add(questLogTable);
            currentState = State.QUESTS;
        } else {
            // Return to gameplay HUD
            setupGameplayHud();
            currentState = State.HUD;
            app.getEventHandler().handleHintMessage();
        }
    }
    
    /**
     * Toggle inventory visibility
     */
    public void toggleInventory() {
        // Clear current state
        topHudPanel.clear();
        bottomHudPanel.clear();
        
        // Update state
        app.getGameState().getGlobalLevelState().setNewItem(false);
        
        if (currentState != State.INVENTORY) {
            // Show inventory
            topHudPanel.add(inventoryTable);
            currentState = State.INVENTORY;
        } else {
            // Return to gameplay HUD
            setupGameplayHud();
            currentState = State.HUD;
            app.getEventHandler().handleHintMessage();
        }
    }
    
    /**
     * Close any open tabs and return to gameplay HUD
     */
    public void closeTabs() {
        setupGameplayHud();
        currentState = State.HUD;
    }
    
    /**
     * Get current HUD state
     */
    public State getState() {
        return currentState;
    }
    
    // Getter methods for components
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
    
    @Override
    public void initWidgets() {
        // Widgets are initialized in initComponents()
    }
    
    @Override
    public void addWidgets() {
        // Widgets are added in setupGameplayHud()
    }
    
    @Override
    public void setListeners() {
        // Listeners are set by individual components
    }
} 
