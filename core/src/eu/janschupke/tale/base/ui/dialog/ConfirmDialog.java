package eu.janschupke.tale.base.ui.dialog;

import eu.janschupke.tale.base.App;

/**
 * Confirmation dialog, containing buttons for accepting or declining.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class ConfirmDialog extends BaseDialog {
    public ConfirmDialog(final App app, String title) {
        super(app, title);
        button(app.getLang().get("menu.global.button.no"), false);
        button(app.getLang().get("menu.global.button.yes"), true);
    }

    @Override
    public void initWidgets() {
        super.initWidgets();
    }

    @Override
    public void addWidgets() {
        super.addWidgets();
    }

    @Override
    public void setListeners() {
    }
}
