package eu.janschupke.buddy.content.ui.dialog;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.BaseDialog;

/**
 * Notification dialog that indicated that an application restart is required.
 */
public class RestartDialog extends BaseDialog {
    private Label label;

    public RestartDialog(final App app) {
        super(app, app.getLang().get("menu.dialog.restart.title"));

        label = new Label(app.getLang().get("menu.dialog.restart.text"), app.getSkin());
        label.setAlignment(Align.center);

        button(app.getLang().get("menu.global.button.ok"), true);
        getContentTable().add(label);

        setModal(true);
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
        hide();
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
