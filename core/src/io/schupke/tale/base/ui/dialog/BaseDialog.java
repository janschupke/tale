package io.schupke.tale.base.ui.dialog;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

import io.schupke.tale.base.App;
import io.schupke.tale.base.ui.UserInterface;
import io.schupke.tale.content.config.Config;

/**
 * Base class for all dialog windows.
 * Provides common functionality for modal dialogs and popups.
 */
public abstract class BaseDialog extends Dialog implements UserInterface {
    protected App app;
    protected Table widgetTable;
    protected Label label;

    private float width = Gdx.graphics.getWidth() * 0.4f;

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

        getBackground().setMinWidth(Config.UI_DIALOG_WIDTH);
        getBackground().setMinHeight(Config.UI_DIALOG_HEIGHT);

        setBackground(app.getResourceManager().getTextureHandler().getHudBackgroundDrawable());
        setMovable(false);
        setModal(true);
    }

    @Override
    public void initWidgets() {
        widgetTable = new Table();
        widgetTable.align(Align.topLeft);

        label = new Label("", app.getSkin());
        label.setAlignment(Align.topLeft);
        label.setWrap(true);
        label.setWidth(width - Config.HUD_INNER_PADDING * 2);

    }

    @Override
    public void addWidgets() {
        getContentTable().add(widgetTable).expand().fill();
        widgetTable.add(label).width(width - Config.HUD_INNER_PADDING * 2).top().left();
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
        return super.show(stage);
    }

    @Override
    public void cancel() {
        super.cancel();
    }

    @Override
    public void hide() {
        Gdx.app.debug("BaseDialog#hide", "Hiding a dialog");
        super.hide();
    }
}
