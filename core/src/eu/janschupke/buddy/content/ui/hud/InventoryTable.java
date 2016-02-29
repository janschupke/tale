package eu.janschupke.buddy.content.ui.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.container.Inventory;
import eu.janschupke.buddy.framework.base.entity.container.InventoryItem;
import eu.janschupke.buddy.framework.base.exception.NoHudException;
import eu.janschupke.buddy.framework.base.ui.table.UITable;
import eu.janschupke.buddy.framework.config.Config;

import java.util.Observable;
import java.util.Observer;

/**
 * GUI table structure for the in-game character inventory.
 *
 * @author jan.schupke@gmail.com
 */
public class InventoryTable extends UITable implements Observer {
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
        setBackground(app.getResourceManager().getTextureHandler().getHudBackgroundDrawable());
        pad(Config.HUD_INNER_PADDING);
        initWidgets();
        addWidgets();
        setListeners();
    }

    /**
     * Update inventory view according to the current model state.
     */
    @Override
    public void update(Observable o, Object arg) {
        itemTable.getChildren().forEach(Actor::remove);

        Inventory inventory = app.getGameState().getInventory();
        for (int i = 0; i < inventory.getUsedSlots(); i++) {
            InventoryItem inventoryItem = inventory.getItem(i);

            // Items are represented as clickable image buttons.
            ImageButton itemButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(
                    inventoryItem.getItem().getSprite().getTexture())));
            itemTable.add(itemButton).pad(Config.HUD_BUTTON_PADDING).row();

            // Item description is displayed after the item button is clicked.
            itemButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    setActiveItem(inventoryItem);
                }
            });
        }

        app.getGameState().getGlobalLevelState().setNewItem(true);
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

    /**
     * Sets the first item from the list as active, to prevent empty content table
     * when some items are in the inventory. If the inventory is empty, does nothing.
     */
    private void setDefaultActiveItem() {
        Inventory inventory = app.getGameState().getInventory();

        if (inventory.getUsedSlots() == 0) {
            clearActiveItem();
            return;
        }

        // Default state so that the description area is not empty.
        if (inventory.getUsedSlots() > 0 && itemNameLabel.getText().toString()
                .equals(app.getLang().get("hud.inventory.label.empty"))) {
            Gdx.app.debug("InventoryTable#setDefaultActiveItem", "Setting default selection");
            setActiveItem(inventory.getItem(0));
        }
    }

    /**
     * Clears the inventory content table texts.
     */
    private void clearActiveItem() {
        itemNameLabel.setText(app.getLang().get("hud.inventory.label.empty"));
        itemDescriptionLabel.setText("");
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
        itemNameLabel = new Label(app.getLang().get("hud.inventory.label.empty"), app.getSkin());
        itemDescriptionLabel = new Label("", app.getSkin());
        closeButton = new TextButton(app.getLang().get("menu.global.button.close"), app.getSkin());
    }

    @Override
    public void addWidgets() {
        add(titleLabel).row();
        descriptionTable.add(itemNameLabel).row();
        descriptionTable.add(itemDescriptionLabel).row();
        add(itemScrollPane).height(Config.HUD_LOG_HEIGHT).padLeft(Config.HUD_INNER_PADDING).fill();
        add(descriptionScrollPane).width(Config.HUD_LOG_DIMINISHED_WIDTH)
                .height(Config.HUD_LOG_HEIGHT).fill().pad(Config.HUD_INNER_PADDING).row();
        add(closeButton).colspan(2);
    }

    @Override
    public void setListeners() {
        closeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                try {
                    app.getHud().toggleInventory();
                } catch (NoHudException e) {
                    Gdx.app.debug("InventoryTable#closeButton#clicked", "Could not get HUD instance");
                }
            }
        });
    }
}
