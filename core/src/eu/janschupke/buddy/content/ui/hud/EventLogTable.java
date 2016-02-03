package eu.janschupke.buddy.content.ui.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.table.UITable;
import eu.janschupke.buddy.framework.config.Config;

/**
 * GUI table structure for event log.
 */
public class EventLogTable extends UITable {
    private Label titleLabel;
    private Label eventArea;
    private ScrollPane eventScrollPane;

    public EventLogTable(final App app) {
        super(app);

        Texture texture = new Texture(Gdx.files.internal("textures/gui/hud-background.png"));
        TextureRegion region = new TextureRegion(texture);
        Drawable drawable = new TextureRegionDrawable(region);

        setBackground(drawable);
        align(Align.top);
        pad(innerPadding);

        initWidgets();
        addWidgets();
        setListeners();
    }

    @Override
    public void initWidgets() {
        titleLabel = new Label(app.getLang().get("hud.event.label.title"), app.getSkin());
        eventArea = new Label("", app.getSkin());
        eventScrollPane = new ScrollPane(eventArea, app.getSkin());
    }

    @Override
    public void addWidgets() {
        add(titleLabel).row();
        add(eventScrollPane).height(Config.HUD_BOTTOM_PANE_HEIGHT).pad(innerPadding);
    }

    @Override
    public void setListeners() {

    }

    public void addEvent(String event) {
        eventArea.setText(eventArea.getText() + "\n" + event);
    }
}
