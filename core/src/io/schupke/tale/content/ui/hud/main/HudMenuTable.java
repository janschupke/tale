package io.schupke.tale.content.ui.hud.main;

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
 * Top menu HUD component as specified in HUD.md.
 * Provides access to main game functions through buttons.
 */
public class HudMenuTable extends UiTable {
    
    public HudMenuTable(final App app) {
        super(app);
        align(Align.topLeft);
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
        
        // Set background for the menu table
        setBackground(drawable);
        pad(Config.HUD_INNER_PADDING / 2, Config.HUD_INNER_PADDING, Config.HUD_INNER_PADDING / 2, Config.HUD_INNER_PADDING);
        
        // Create menu buttons as specified in HUD.md with hotkeys
        createMenuButton("hud.menu.menu", " (ESC)", () -> {
            app.getResourceManager().getSoundHandler()
                    .playSound(app.getResourceManager().getSoundHandler().getHeavyButtonSound());
            ((io.schupke.tale.base.screen.GameScreen) app.getScreen()).toggleMenu();
        });
        
        createMenuButton("hud.menu.messages", " (E)", () -> {
            app.getResourceManager().getSoundHandler()
                    .playSound(app.getResourceManager().getSoundHandler().getHeavyButtonSound());
            ((io.schupke.tale.base.screen.GameScreen) app.getScreen()).toggleEventLog();
        });
        
        createMenuButton("hud.menu.quests", " (Q)", () -> {
            app.getResourceManager().getSoundHandler()
                    .playSound(app.getResourceManager().getSoundHandler().getHeavyButtonSound());
            ((io.schupke.tale.base.screen.GameScreen) app.getScreen()).toggleQuestLog();
        });
        
        createMenuButton("hud.menu.inventory", " (I)", () -> {
            app.getResourceManager().getSoundHandler()
                    .playSound(app.getResourceManager().getSoundHandler().getHeavyButtonSound());
            ((io.schupke.tale.base.screen.GameScreen) app.getScreen()).toggleInventory();
        });
    }
    
    /**
     * Create a menu button with the specified text, hotkey, and action
     */
    private void createMenuButton(String textKey, String hotkey, Runnable action) {
        String buttonText = app.getLang().get(textKey) + hotkey;
        TextButton button = new TextButton(buttonText, app.getSkin());
        button.setWidth(Config.HUD_TOP_BUTTON_WIDTH);
        button.setHeight(Config.HUD_TOP_BUTTON_WIDTH);
        button.pad(Config.HUD_BUTTON_PADDING);
        
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                action.run();
            }
        });
        
        add(button).pad(Config.HUD_BUTTON_PADDING);
    }
    
    @Override
    public void addWidgets() {
        // Widgets are added in initWidgets()
    }
    
    @Override
    public void setListeners() {
        // Listeners are set in initWidgets()
    }
} 
