package eu.janschupke.tale.base.ui.table;

import com.badlogic.gdx.utils.Align;
import eu.janschupke.tale.base.App;

/**
 * Generic Table extension, serving as a base for all HUDs and UIs.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class RootTable extends UiTable {
    public RootTable(final App app) {
        super(app);
        setFillParent(true);
        setPosition(0, 0);
        align(Align.topLeft);
    }
}
