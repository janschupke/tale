package eu.janschupke.buddy.framework.base.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Base class for all GUI dialogs.
 */
public abstract class BaseDialog extends Dialog implements UserInterface {
    protected App app;
    private boolean shown;
    private boolean open;
    protected Table widgetTable;

    protected int dialogWidth = Config.UI_DIALOG_WIDTH;
    protected int dialogHeight = Config.UI_DIALOG_HEIGHT;

    public BaseDialog(final App app, String title) {
        super(title, app.getSkin());
        this.app = app;

        key(Input.Keys.ENTER, true);
        key(Input.Keys.ESCAPE, false);
        getBackground().setMinWidth(dialogWidth);
        getBackground().setMinHeight(dialogHeight);
        setMovable(false);

        widgetTable = new Table();
        widgetTable.setFillParent(true);
        getContentTable().add(widgetTable);

//        Texture texture = new Texture(Gdx.files.internal("textures/gui/dialog-background.png"));
//        TextureRegion region = new TextureRegion(texture);
//        Drawable drawable = new TextureRegionDrawable(region);
//        setBackground(drawable);
    }

    public boolean isShown() {
        return shown;
    }

    public boolean isOpen() {
        return open;
    }

    @Override
    protected void result(Object object) {
        boolean result = (Boolean) object;
        if (result) {
            Gdx.app.debug("BaseDialog#result", "Closing a dialog");
            open = false;
            hide();
        }
    }

    @Override
    public Dialog show(Stage stage) {
        shown = true;
        open = true;
        return super.show(stage);
    }

    @Override
    public void hide() {
        Gdx.app.debug("BaseDialog#hide", "Hiding a dialog");
        shown = false;
        super.hide();
    }
}
