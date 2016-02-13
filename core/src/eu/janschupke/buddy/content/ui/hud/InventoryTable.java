package eu.janschupke.buddy.content.ui.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.container.Inventory;
import eu.janschupke.buddy.framework.base.entity.container.InventoryItem;
import eu.janschupke.buddy.framework.base.exception.NoHudException;
import eu.janschupke.buddy.framework.base.ui.table.UITable;
import eu.janschupke.buddy.framework.config.Config;
import eu.janschupke.buddy.framework.util.Utility;

/**
 * GUI table structure for the in-game character inventory.
 */
public class InventoryTable extends UITable {
    private Label titleLabel;
    private Table itemTable;
    private ScrollPane itemScrollPane;
    private Table descriptionTable;
    private ScrollPane descriptionScrollPane;
    private Label itemNameLabel;
    private Label itemDescriptionLabel;
    private TextButton closeButton;

    public InventoryTable(final App app) {
        super(app);

        Texture texture = new Texture(Gdx.files.internal("textures/gui/hud-background.png"));
        TextureRegion region = new TextureRegion(texture);
        Drawable drawable = new TextureRegionDrawable(region);

        setBackground(drawable);
        pad(Config.HUD_INNER_PADDING);

        initWidgets();
        addWidgets();
        setListeners();
    }

    /**
     * Update inventory view according to the current
     * model state.
     */
    public void update() {
        itemTable.getChildren().forEach(Actor::remove);

        Inventory inventory = app.getGameState().getInventory();
        for (int i = 0; i < inventory.getUsedSlots(); i++) {
            InventoryItem inventoryItem = inventory.getItem(i);
            ImageButton itemButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(
                    inventoryItem.getItem().getSprite().getTexture())));
            itemTable.add(itemButton).pad(Config.HUD_BUTTON_PADDING).row();
            itemButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    setActiveItem(inventoryItem);
                }
            });
        }

        updateIndicator();
        setDefaultActiveItem();
    }

    /**
     * Fills the description area with information about
     * the currently selected item.
     */
    private void setActiveItem(InventoryItem item) {
        itemNameLabel.setText(item.getItem().getName());
        itemDescriptionLabel.setText(item.getItem().getDescription());
    }

    private void setDefaultActiveItem() {
        Inventory inventory = app.getGameState().getInventory();

        // Default state so that the description area is not empty.
        if (inventory.getUsedSlots() > 0 && itemNameLabel.getText().toString().equals("")) {
            Gdx.app.debug("InventoryTable#setDefaultActiveItem", "Setting default selection");
            setActiveItem(inventory.getItem(0));
        }
    }

    private void updateIndicator() {
        try {
            Utility.getHud(app).getIndicatorTable().activateItem();
        } catch (NoHudException e) {}
        catch (IndexOutOfBoundsException e) {
            // TODO
        }
    }

    @Override
    public void initWidgets() {
        titleLabel = new Label(app.getLang().get("hud.inventory.label.title"), app.getSkin());
        itemTable = new Table();
        itemTable.align(Align.top);
        itemTable.padTop(Config.HUD_INNER_PADDING);
        itemScrollPane = new ScrollPane(itemTable, app.getSkin());
        descriptionTable = new Table();
        descriptionTable.align(Align.top);
        descriptionTable.padTop(Config.HUD_INNER_PADDING);
        descriptionScrollPane = new ScrollPane(descriptionTable, app.getSkin());
        itemNameLabel = new Label("", app.getSkin());
        itemDescriptionLabel = new Label("", app.getSkin());
        closeButton = new TextButton(app.getLang().get("menu.global.button.close"), app.getSkin());
    }

    @Override
    public void addWidgets() {
        add(titleLabel).row();
        descriptionTable.add(itemNameLabel).row();
        descriptionTable.add(itemDescriptionLabel).row();
        add(itemScrollPane).height(Config.HUD_LOG_HEIGHT).padLeft(Config.HUD_INNER_PADDING).fill();
        add(descriptionScrollPane).width(Config.HUD_LOG_DIMINISHED_WIDTH).height(Config.HUD_LOG_HEIGHT).fill().pad(Config.HUD_INNER_PADDING).row();
        add(closeButton).colspan(2);
    }

    @Override
    public void setListeners() {
        closeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                try {
                    Utility.getHud(app).toggleInventory();
                } catch (NoHudException e) {
                }
            }
        });
    }
}
