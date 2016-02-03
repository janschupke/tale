package eu.janschupke.buddy.content.ui.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.table.UITable;

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

    @Override
    public void initWidgets() {
    }

    @Override
    public void addWidgets() {
        for (int i = 0; i < 10; i++) {
            ImageButton itemButton;
            itemButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(
                    new Texture(Gdx.files.internal("textures/gui/application-icon.png")))));
            add(itemButton).pad(buttonPadding);
        }
    }

    @Override
    public void setListeners() {

    }
}
