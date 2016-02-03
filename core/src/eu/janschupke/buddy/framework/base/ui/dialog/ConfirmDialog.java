package eu.janschupke.buddy.framework.base.ui.dialog;

import eu.janschupke.buddy.framework.App;

/**
 * Confirmation dialog, containing buttons for accepting or declining.
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
    public void setListeners() {}
}
