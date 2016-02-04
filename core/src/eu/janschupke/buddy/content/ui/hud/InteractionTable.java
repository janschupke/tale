package eu.janschupke.buddy.content.ui.hud;

import com.badlogic.gdx.utils.Align;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.table.UITable;
import eu.janschupke.buddy.framework.config.Config;

/**
 * GUI table structure for the interaction pane.
 */
public class InteractionTable extends UITable {
    public InteractionTable(final App app) {
        super(app);

        align(Align.topLeft);
        pad(Config.HUD_INNER_PADDING);

        initWidgets();
        addWidgets();
        setListeners();
    }

    @Override
    public void initWidgets() {
    }

    @Override
    public void addWidgets() {
    }

    @Override
    public void setListeners() {

    }
}
