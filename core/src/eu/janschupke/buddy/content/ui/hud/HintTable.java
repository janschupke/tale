package eu.janschupke.buddy.content.ui.hud;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.table.UITable;

/**
 * Transparent table in the middle of the screen,
 * showing context hints.
 */
public class HintTable extends UITable {
    private Label hintLabel;

    public HintTable(final App app) {
        super(app);

        initWidgets();
        addWidgets();
        setListeners();
    }

    @Override
    public void initWidgets() {
        hintLabel = new Label("", app.getSkin());
    }

    @Override
    public void addWidgets() {
        add(hintLabel).bottom();
    }

    @Override
    public void setListeners() {

    }

    public void update(String hint) {
        hintLabel.setText(hint);
    }

    public void clear() {
        hintLabel.setText("");
    }
}
