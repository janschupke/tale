package eu.janschupke.tale.base.ui.dialog;

import eu.janschupke.tale.base.App;

/**
 * Simple dialog with one button to dismiss it.
 *
 * @author jan.schupke@gmail.com
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
