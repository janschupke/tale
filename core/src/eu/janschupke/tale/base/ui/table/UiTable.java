package eu.janschupke.tale.base.ui.table;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.ui.UserInterface;

/**
 * Base table class for all UI components.
 * Provides common functionality for UI layout and styling.
 */
public abstract class UiTable extends Table implements UserInterface {
    protected final App app;

    public UiTable(final App app) {
        this.app = app;
        setDebug(app.getSettingsManager().getConfig().isUiDebugRendering());
    }
}
