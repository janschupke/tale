package eu.janschupke.buddy.framework.base.ui.table;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import eu.janschupke.buddy.framework.App;

/**
 * Base class for level HUDs.
 */
public abstract class HudTable extends RootTable {
    protected Table topHudTable;
    protected Table bottomHudTable;

    public HudTable(final App app) {
        super(app);

        align(Align.top | Align.center);

        topHudTable = new Table();
        bottomHudTable = new Table();

        add(topHudTable).expandX().expandY().fillY().top().row();
        add(bottomHudTable).fillX();
    }
}
