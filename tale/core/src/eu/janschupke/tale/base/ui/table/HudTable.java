package eu.janschupke.tale.base.ui.table;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import eu.janschupke.tale.base.App;

/**
 * Base class for level HUDs.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class HudTable extends RootTable {
    protected Table topHudPanel;
    protected Table bottomHudPanel;

    public HudTable(final App app) {
        super(app);

        align(Align.top | Align.center);

        topHudPanel = new Table();
        bottomHudPanel = new Table();

        add(topHudPanel).expandX().expandY().fillY().top().row();
        add(bottomHudPanel).fillX();
    }
}
