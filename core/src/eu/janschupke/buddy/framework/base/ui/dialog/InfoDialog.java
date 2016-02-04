package eu.janschupke.buddy.framework.base.ui.dialog;

import eu.janschupke.buddy.framework.App;

/**
 * Simple dialog with one button to dismiss it.
 */
public abstract class InfoDialog extends BaseDialog {
    public InfoDialog(final App app, String title) {
        super(app, title);

        addButton(app.getLang().get("menu.global.button.close"), true);
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