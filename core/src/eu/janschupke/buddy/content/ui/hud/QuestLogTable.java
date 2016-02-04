package eu.janschupke.buddy.content.ui.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.table.UITable;
import eu.janschupke.buddy.framework.config.Config;

/**
 * GUI table structure for the quest log.
 */
public class QuestLogTable extends UITable {
    private Label titleLabel;

    public QuestLogTable(final App app) {
        super(app);

        Texture texture = new Texture(Gdx.files.internal("textures/gui/hud-background.png"));
        TextureRegion region = new TextureRegion(texture);
        Drawable drawable = new TextureRegionDrawable(region);

        setBackground(drawable);
        align(Align.top);
        pad(Config.HUD_INNER_PADDING);

        initWidgets();
        addWidgets();
        setListeners();
    }

    @Override
    public void initWidgets() {
        titleLabel = new Label(app.getLang().get("hud.quest.label.title"), app.getSkin());
    }

    @Override
    public void addWidgets() {
        add(titleLabel);
    }

    @Override
    public void setListeners() {

    }
}
