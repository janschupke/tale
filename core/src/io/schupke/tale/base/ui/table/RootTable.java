package io.schupke.tale.base.ui.table;

import com.badlogic.gdx.utils.Align;

import io.schupke.tale.base.App;

/**
 * Root table that serves as the main container for UI elements.
 * Provides the foundation for all UI layouts.
 */
public abstract class RootTable extends UiTable {
    public RootTable(final App app) {
        super(app);
        setFillParent(true);
        setPosition(0, 0);
        align(Align.topLeft);
    }
}
