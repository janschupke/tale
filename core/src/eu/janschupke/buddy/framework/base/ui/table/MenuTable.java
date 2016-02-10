package eu.janschupke.buddy.framework.base.ui.table;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Formatted menu UI base class.
 */
public abstract class MenuTable extends RootTable {
    public MenuTable(final App app) {
        super(app);

        Texture texture = new Texture(Gdx.files.internal("textures/gui/menu-background.png"));
        TextureRegion region = new TextureRegion(texture);
        Drawable drawable = new TextureRegionDrawable(region);
        setBackground(drawable);

        align(Align.top | Align.center);
        padTop(Config.UI_INDENT_TOP);
    }
}
