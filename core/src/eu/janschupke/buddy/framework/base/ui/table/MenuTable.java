package eu.janschupke.buddy.framework.base.ui.table;

import com.badlogic.gdx.utils.Align;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Formatted menu UI base class.
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
