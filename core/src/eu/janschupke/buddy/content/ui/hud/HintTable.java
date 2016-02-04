package eu.janschupke.buddy.content.ui.hud;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.table.UITable;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Transparent table in the middle of the screen,
 * showing context hints.
 */
public class HintTable extends UITable {
    private Label hintLabel;

    public HintTable(final App app) {
        super(app);

        align(Align.bottom);

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
        add(hintLabel).padBottom(Config.HUD_HINT_BOTTOM_PADDING).padLeft(Config.HUD_HINT_LEFT_PADDING);
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
