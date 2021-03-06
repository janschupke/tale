package eu.janschupke.tale.base.ui.table;

import com.badlogic.gdx.utils.Align;
import eu.janschupke.tale.base.App;
import eu.janschupke.tale.content.config.Config;

/**
 * Formatted menu UI base class.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class MenuTable extends RootTable {
    public MenuTable(final App app) {
        super(app);
        setBackground(app.getResourceManager().getTextureHandler().getMenuBackgroundDrawable());
        align(Align.top | Align.center);
        padTop(Config.UI_INDENT_TOP);
    }
}
