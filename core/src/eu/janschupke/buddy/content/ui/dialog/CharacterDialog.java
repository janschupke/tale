package eu.janschupke.buddy.content.ui.dialog;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.BaseDialog;

/**
 * Dialog window containing character (player) information.
 */
public class CharacterDialog extends BaseDialog {
    public CharacterDialog(final App app) {
        super(app, app.getLang().get("gui.dialog.character.title"));

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
