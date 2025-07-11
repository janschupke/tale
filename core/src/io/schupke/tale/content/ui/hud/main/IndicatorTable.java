package io.schupke.tale.content.ui.hud.main;

import java.util.Observer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

import io.schupke.tale.base.App;
import io.schupke.tale.base.ui.table.UiTable;
import io.schupke.tale.content.config.Config;

/**
 * Status indicators as specified in HUD.md.
 * Shows notifications for new events, quests, and items.
 */
public class IndicatorTable extends UiTable implements Observer {
    
    private TextButton newMessageButton;
    private TextButton newQuestButton;
    private TextButton newItemButton;
    private float width = Config.HUD_INDICATOR_WIDTH;
    
    public IndicatorTable(final App app) {
        super(app);
        align(Align.bottomLeft);
        initWidgets();
        addWidgets();
        setListeners();
    }
    
    @Override
    public void initWidgets() {
        // Create background texture
        Texture hudTexture = new Texture(Gdx.files.internal("textures/gui/hud-background.png"));
        TextureRegion region = new TextureRegion(hudTexture);
        Drawable drawable = new TextureRegionDrawable(region);
        
        // Set background for the indicator table
        setBackground(drawable);
        pad(Config.HUD_INNER_PADDING);
        
        // Create indicator buttons
        newMessageButton = new TextButton(app.getLang().get("hud.indicator.message"), app.getSkin());
        newQuestButton = new TextButton(app.getLang().get("hud.indicator.quest"), app.getSkin());
        newItemButton = new TextButton(app.getLang().get("hud.indicator.item"), app.getSkin());
        
        // Set button properties
        newMessageButton.setWidth(width);
        newQuestButton.setWidth(width);
        newItemButton.setWidth(width);
        
        newMessageButton.pad(Config.HUD_BUTTON_PADDING);
        newQuestButton.pad(Config.HUD_BUTTON_PADDING);
        newItemButton.pad(Config.HUD_BUTTON_PADDING);
    }
    
    @Override
    public void addWidgets() {
        // Add buttons to layout
        add(newMessageButton).pad(Config.HUD_BUTTON_PADDING).row();
        add(newQuestButton).pad(Config.HUD_BUTTON_PADDING).row();
        add(newItemButton).pad(Config.HUD_BUTTON_PADDING);
    }
    
    @Override
    public void setListeners() {
        // Add click listeners for navigation
        newMessageButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getGameState().getGlobalLevelState().setNewEvent(false);
                ((io.schupke.tale.base.screen.GameScreen) app.getScreen()).toggleEventLog();
            }
        });
        
        newQuestButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getGameState().getGlobalLevelState().setNewQuest(false);
                ((io.schupke.tale.base.screen.GameScreen) app.getScreen()).toggleQuestLog();
            }
        });
        
        newItemButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getGameState().getGlobalLevelState().setNewItem(false);
                ((io.schupke.tale.base.screen.GameScreen) app.getScreen()).toggleInventory();
            }
        });
    }
    
    @Override
    public void update(java.util.Observable observable, Object arg) {
        // Update button visibility based on state
        boolean hasNewEvent = app.getGameState().getGlobalLevelState().isNewEvent();
        boolean hasNewQuest = app.getGameState().getGlobalLevelState().isNewQuest();
        boolean hasNewItem = app.getGameState().getGlobalLevelState().isNewItem();
        
        newMessageButton.setVisible(hasNewEvent);
        newQuestButton.setVisible(hasNewQuest);
        newItemButton.setVisible(hasNewItem);
        
        // Hide the entire indicator table if there are no indicators to show
        setVisible(hasNewEvent || hasNewQuest || hasNewItem);
    }
} 
