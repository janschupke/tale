package eu.janschupke.tale.framework.base.ui.table;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.base.ui.UserInterface;

/**
 * Base class for all Scene2d tables used in the application.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class UiTable extends Table implements UserInterface {
    protected final App app;

    public UiTable(final App app) {
        this.app = app;
        setDebug(app.getSettingsManager().getConfig().isUiDebugRendering());
    }
}
