package eu.janschupke.buddy.content.ui.hud;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.table.UITable;
import eu.janschupke.buddy.framework.config.Config;

/**
 * GUI table structure for the interaction pane.
 */
public class InteractionTable extends UITable {
    private Label titleLabel;
    private Label descriptionLabel;
    private Table optionTable;

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
        titleLabel = new Label("", app.getSkin());
        descriptionLabel = new Label("", app.getSkin());
        optionTable = new Table();
    }

    @Override
    public void addWidgets() {
        add(titleLabel).row();
        add(descriptionLabel).row();
        add(optionTable);
    }

    @Override
    public void setListeners() {

    }
}
