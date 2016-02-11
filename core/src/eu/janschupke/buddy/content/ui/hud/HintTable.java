package eu.janschupke.buddy.content.ui.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.table.UITable;

/**
 * Transparent table in the middle of the screen,
 * showing context hints.
 */
public class HintTable extends UITable {
    private Label hintLabel;
    private Table messageTable;

    public HintTable(final App app) {
        super(app);

        align(Align.center);
        initWidgets();
        addWidgets();
        setListeners();
    }

    @Override
    public void initWidgets() {
        Texture hintTexture = new Texture(Gdx.files.internal("textures/gui/hud-background.png"));
        TextureRegion region = new TextureRegion(hintTexture);
        Drawable drawable = new TextureRegionDrawable(region);

        messageTable = new Table();
        messageTable.setBackground(drawable);

        hintLabel = new Label("", app.getSkin());
    }

    @Override
    public void addWidgets() {
        messageTable.add(hintLabel);
    }

    @Override
    public void setListeners() {}

    public void update(String hint) {
        if (hint == null || hint.isEmpty()) {
            clear();
            return;
        }

        hintLabel.setText(hint);
        add(messageTable);
    }

    public void clear() {
        hintLabel.setText("");
        removeActor(messageTable);
    }

    public String getHint() {
        return hintLabel.getText().toString();
    }
}
