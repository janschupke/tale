package eu.janschupke.buddy.content.ui.dialog;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.BaseDialog;

/**
 * In-game inventory GUI.
 */
public class InventoryDialog extends BaseDialog {
    public InventoryDialog(final App app) {
        super(app, app.getLang().get("gui.dialog.inventory.title"));

        button(app.getLang().get("menu.global.button.close"), true);

        setMovable(true);
        setModal(false);
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
