package eu.janschupke.buddy.framework.base.ui.table;

import com.badlogic.gdx.utils.Align;
import eu.janschupke.buddy.framework.App;

/**
 * Generic Table extension, serving as a base for all HUDs and UIs.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class RootTable extends UITable {
    public RootTable(final App app) {
        super(app);
        setFillParent(true);
        setPosition(0, 0);
        align(Align.topLeft);
    }
}
