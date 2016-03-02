package eu.janschupke.tale.content.ui.dialog;

import com.badlogic.gdx.Gdx;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.base.ui.dialog.ConfirmDialog;

/**
 * Default settings reset dialog.
 *
 * @author jan.schupke@gmail.com
 */
public class DefaultSettingDialog extends ConfirmDialog {
    public DefaultSettingDialog(final App app) {
        super(app, app.getLang().get("menu.dialog.default-settings.title"));
        label.setText(app.getLang().get("menu.dialog.default-settings.text"));
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
}
