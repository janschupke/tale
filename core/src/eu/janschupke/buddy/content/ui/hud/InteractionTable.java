package eu.janschupke.buddy.content.ui.hud;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.table.UITable;

/**
 * GUI table structure for the interaction pane.
 */
public class InteractionTable extends UITable {
    private Label titleLabel;

    public InteractionTable(final App app) {
        super(app);

        align(Align.topLeft);
        pad(innerPadding);

        initWidgets();
        addWidgets();
        setListeners();
    }

    @Override
    public void initWidgets() {
        titleLabel = new Label(app.getLang().get("hud.interaction.label.title"), app.getSkin());
    }

    @Override
    public void addWidgets() {
        add(titleLabel);
    }

    @Override
    public void setListeners() {

    }
}
