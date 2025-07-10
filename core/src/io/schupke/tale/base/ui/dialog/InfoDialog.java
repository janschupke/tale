package io.schupke.tale.base.ui.dialog;

import io.schupke.tale.base.App;

/**
 * Dialog for displaying information to the user.
 * Shows informational messages with an OK button.
 */
public abstract class InfoDialog extends BaseDialog {
    public InfoDialog(final App app, String title) {
        super(app, title);
        button(app.getLang().get("menu.global.button.close"), true);
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
