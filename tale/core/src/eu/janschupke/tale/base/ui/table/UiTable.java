package eu.janschupke.tale.base.ui.table;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.ui.UserInterface;

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
