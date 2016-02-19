package eu.janschupke.buddy.framework.base.ui.dialog;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.UserInterface;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Base class for all GUI dialogs.
 * @author jan.schupke@gmail.com
 */
public abstract class BaseDialog extends Dialog implements UserInterface {
    protected App app;
    private boolean shown;
    protected Table widgetTable;
    protected Label label;

    protected int dialogWidth = Config.UI_DIALOG_WIDTH;
    protected int dialogHeight = Config.UI_DIALOG_HEIGHT;

    public BaseDialog(final App app, String title) {
        super(title, app.getSkin());
        this.app = app;

        init();
        initWidgets();
        addWidgets();
        setListeners();
    }

    private void init() {
        key(Input.Keys.ENTER, true);
        key(Input.Keys.ESCAPE, false);

        padTop(Config.DIALOG_TOP_PADDING);
        padBottom(Config.DIALOG_BOTTOM_PADDING);
        padRight(Config.DIALOG_SIDE_PADDING);
        padLeft(Config.DIALOG_SIDE_PADDING);

        getButtonTable().padTop(Config.DIALOG_BUTTON_TOP_PADDING);

        getBackground().setMinWidth(dialogWidth);
        getBackground().setMinHeight(dialogHeight);

        Texture texture = new Texture(Gdx.files.internal("textures/gui/hud-background.png"));
        TextureRegion region = new TextureRegion(texture);
        Drawable drawable = new TextureRegionDrawable(region);
        setBackground(drawable);

        setMovable(false);
        setModal(true);
    }

    @Override
    public void initWidgets() {
        widgetTable = new Table();
        widgetTable.align(Align.topLeft);

        label = new Label("", app.getSkin());
        label.setAlignment(Align.center);

    }

    @Override
    public void addWidgets() {
        getContentTable().add(widgetTable).expand().fill();
        widgetTable.add(label).top().left();
    }

    public boolean isShown() {
        return shown;
    }

    @Override
    protected void result(Object object) {
        boolean result = (Boolean) object;
        if (result) {
            Gdx.app.debug("BaseDialog#result", "Closing a dialog");
            hide();
        }
    }

    @Override
    public Dialog show(Stage stage) {
        shown = true;
        return super.show(stage);
    }

    @Override
    public void cancel() {
        super.cancel();
    }

    @Override
    public void hide() {
        Gdx.app.debug("BaseDialog#hide", "Hiding a dialog");
        shown = false;
        super.hide();
    }
}
