package eu.janschupke.buddy.framework.base.ui.table;

import com.badlogic.gdx.utils.Align;
import eu.janschupke.buddy.framework.App;

/**
 * Formatted menu UI base class.
 */
public abstract class MenuTable extends RootTable {
    public MenuTable(final App app) {
        super(app);

        align(Align.top | Align.center);
        padTop(indentTop);
    }
}
