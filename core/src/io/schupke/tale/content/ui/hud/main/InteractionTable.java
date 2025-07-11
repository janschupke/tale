package io.schupke.tale.content.ui.hud.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

import io.schupke.tale.base.App;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.ui.table.UiTable;
import io.schupke.tale.content.config.Config;

/**
 * Bottom interaction panel as specified in HUD.md.
 * Displays interaction options and decisions.
 */
public class InteractionTable extends UiTable {
    
    private Table contentTable;
    private Label titleLabel;
    private Label descriptionLabel;
    private Table optionTable;
    private float width = Gdx.graphics.getWidth() * 0.75f;
    
    public InteractionTable(final App app) {
        super(app);
        align(Align.topLeft);
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
        
        // Create content table with background
        contentTable = new Table();
        contentTable.pad(Config.HUD_INNER_PADDING);
        contentTable.setBackground(drawable);
        
        // Create labels
        titleLabel = new Label("", app.getSkin());
        descriptionLabel = new Label("", app.getSkin());
        optionTable = new Table();
    }
    
    @Override
    public void addWidgets() {
        // Content will be added dynamically in update() method
    }
    
    @Override
    public void setListeners() {
        // Listeners are added dynamically in update() method
    }
    
    /**
     * Updates the table based on the current interaction.
     */
    public void update(Interaction interaction) {
        Gdx.app.debug("InteractionTable#update", "Updating");
        
        // Clear existing content
        clear();
        contentTable.clear();
        optionTable.clear();
        
        // Set interaction content
        titleLabel.setText(interaction.getTitle());
        descriptionLabel.setText(interaction.getDescription());
        descriptionLabel.setWrap(true);
        descriptionLabel.setWidth(width - Config.HUD_INNER_PADDING * 2);
        descriptionLabel.setAlignment(Align.center);
        
        // Create decision buttons
        for (Decision decision : interaction.getCurrentSituation().getDecisions()) {
            if (!decision.isAvailable()) {
                continue;
            }
            
            TextButton button = new TextButton(decision.getDescription(), app.getSkin());
            button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    interaction.handle(decision);
                    app.getResourceManager().getSoundHandler()
                            .playSound(app.getResourceManager().getSoundHandler().getLightButtonSound());
                }
            });
            
            optionTable.add(button).left().pad(Config.HUD_BUTTON_PADDING_DIM).row();
        }
        
        // Add content to table
        contentTable.add(titleLabel).padBottom(Config.HUD_INNER_PADDING).row();
        contentTable.add(descriptionLabel).width(width - Config.HUD_INNER_PADDING * 2).row();
        contentTable.add(optionTable);
        
        add(contentTable).expand().fill();
    }
    
    /**
     * Removes content and hides the interaction table.
     */
    public void free() {
        Gdx.app.debug("InteractionTable#free", "Freeing");
        titleLabel.setText("");
        descriptionLabel.setText("");
        optionTable.clear();
        contentTable.clear();
        clear();
    }
} 
