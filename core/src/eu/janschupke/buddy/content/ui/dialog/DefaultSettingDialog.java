package eu.janschupke.buddy.content.ui.dialog;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.BaseDialog;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Default settings reset dialog.
 */
public class DefaultSettingDialog extends BaseDialog {
    private Label label;

    public DefaultSettingDialog(final App app) {
        super(app, app.getLang().get("menu.dialog.default-settings.title"));

        label = new Label(app.getLang().get("menu.dialog.default-settings.text"), app.getSkin());
        label.setAlignment(Align.center);

        button(app.getLang().get("menu.global.button.no"), false);
        button(app.getLang().get("menu.global.button.yes"), true);
        // TODO: padding, universally in all dialogs.
        getContentTable().add(label).pad(Config.HUD_INNER_PADDING);
    }

    @Override
    public void initWidgets() {

    }

    @Override
    public void addWidgets() {

    }

    @Override
    public void setListeners() {

    }

    @Override
    protected void result(Object object) {
        boolean result = (Boolean) object;

        if (result) {
            Gdx.app.debug("DefaultSettingsDialog#result", "True");
            app.getSettingsManager().reset();
        } else {
            remove();
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
}
