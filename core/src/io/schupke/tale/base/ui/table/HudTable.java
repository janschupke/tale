package io.schupke.tale.base.ui.table;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

import io.schupke.tale.base.App;

/**
 * Base HUD table that provides the standard layout structure.
 * Follows the HUD.md specifications for top and bottom panels.
 */
public abstract class HudTable extends RootTable {
    protected Table topHudPanel;
    protected Table bottomHudPanel;

    public HudTable(final App app) {
        super(app);
        
        // Setup the main HUD layout as specified in HUD.md
        align(Align.top | Align.center);
        
        // Create the two main panels
        topHudPanel = new Table();
        bottomHudPanel = new Table();
        
        // Add panels to the layout
        // Top panel takes up most of the screen
        add(topHudPanel).expandX().expandY().fillY().top().row();
        // Bottom panel takes the bottom portion
        add(bottomHudPanel).fillX();
    }
} 
