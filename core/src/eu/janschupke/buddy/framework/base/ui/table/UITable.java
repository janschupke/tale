package eu.janschupke.buddy.framework.base.ui.table;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.UserInterface;

/**
 * Base class for all Scene2d tables used in the application.
 * @author jan.schupke@gmail.com
 */
public abstract class UITable extends Table implements UserInterface {
    protected final App app;

    public UITable(final App app) {
        this.app = app;
        setDebug(app.getSettingsManager().getConfig().isUiDebugRendering());
    }
}
