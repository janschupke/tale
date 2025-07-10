package io.schupke.tale.content.ui.dialog;

import io.schupke.tale.base.App;
import io.schupke.tale.base.ui.dialog.InfoDialog;

/**
 * Notification dialog that indicated that an application restart is required.
 *
 * @author jan.schupke@gmail.com
 */
public class RestartDialog extends InfoDialog {
    public RestartDialog(final App app) {
        super(app, app.getLang().get("menu.dialog.restart.title"));
        label.setText(app.getLang().get("menu.dialog.restart.text"));
    }
}
