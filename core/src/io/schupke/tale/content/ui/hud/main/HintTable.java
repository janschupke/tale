package io.schupke.tale.content.ui.hud.main;

import java.util.Observer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

import io.schupke.tale.base.App;
import io.schupke.tale.base.ui.table.UiTable;
import io.schupke.tale.content.config.Config;

/**
 * Center hint display as specified in HUD.md.
 * Shows contextual hints and interaction prompts.
 */
public class HintTable extends UiTable implements Observer {
    
    private Table messageTable;
    private Label hintLabel;
    private float width = Config.HUD_HINT_WIDTH;
    
    public HintTable(final App app) {
        super(app);
        align(Align.center);
        initWidgets();
        addWidgets();
        setListeners();
    }
    
    @Override
    public void initWidgets() {
        // Create background texture
        Texture hintTexture = new Texture(Gdx.files.internal("textures/gui/hud-background.png"));
        TextureRegion region = new TextureRegion(hintTexture);
        Drawable drawable = new TextureRegionDrawable(region);
        
        // Create message table with background
        messageTable = new Table();
        messageTable.pad(Config.HUD_INNER_PADDING);
        messageTable.setBackground(drawable);
        
        // Create hint label
        hintLabel = new Label("", app.getSkin());
        hintLabel.setAlignment(Align.center);
        hintLabel.setWrap(true);
        hintLabel.setWidth(width - Config.HUD_INNER_PADDING * 2);
    }
    
    @Override
    public void addWidgets() {
        messageTable.add(hintLabel).width(width - Config.HUD_INNER_PADDING * 2);
        add(messageTable);
    }
    
    @Override
    public void setListeners() {
        // Add click listener to trigger interactions
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Trigger available interactions when hint is clicked
                if (app.getGameState().getGlobalLevelState().getCurrentHint() != null &&
                    !app.getGameState().getGlobalLevelState().getCurrentHint().isEmpty()) {
                    // This will trigger interaction if available
                    app.getEventHandler().handleHintMessage();
                }
            }
        });
    }
    
    @Override
    public void update(java.util.Observable observable, Object arg) {
        // Update hint text when state changes
        String currentHint = app.getGameState().getGlobalLevelState().getCurrentHint();
        if (currentHint != null && !currentHint.isEmpty()) {
            // Add hotkey information to the hint
            hintLabel.setText(currentHint + " (H)");
            setVisible(true);
        } else {
            setVisible(false);
        }
    }
} 
