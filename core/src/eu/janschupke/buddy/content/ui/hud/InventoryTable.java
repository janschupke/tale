package eu.janschupke.buddy.content.ui.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.container.Inventory;
import eu.janschupke.buddy.framework.base.entity.container.InventoryItem;
import eu.janschupke.buddy.framework.base.ui.table.UITable;
import eu.janschupke.buddy.framework.config.Config;

/**
 * GUI table structure for the in-game character inventory.
 */
public class InventoryTable extends UITable {
    public InventoryTable(final App app) {
        super(app);

        Texture texture = new Texture(Gdx.files.internal("textures/gui/hud-background.png"));
        TextureRegion region = new TextureRegion(texture);
        Drawable drawable = new TextureRegionDrawable(region);

        setBackground(drawable);

        initWidgets();
        addWidgets();
        setListeners();
    }

    /**
     * Update inventory view according to the current
     * model state.
     */
    public void update() {
        getChildren().forEach(Actor::remove);

        Inventory inventory = app.getGameState().getInventory();
        for (int i = 0; i < inventory.getUsedSlots(); i++) {
            InventoryItem inventoryItem = inventory.getItem(i);
            ImageButton itemButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(
                    inventoryItem.getItem().getSprite().getTexture())));
            add(itemButton).pad(Config.HUD_BUTTON_PADDING);
        }
    }

    @Override
    public void initWidgets() {}

    @Override
    public void addWidgets() {}

    @Override
    public void setListeners() {}
}
