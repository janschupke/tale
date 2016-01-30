package eu.janschupke.buddy.content.ui.dialog;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.BaseDialog;

/**
 * Dialog window containing quests and their details.
 */
public class QuestDialog extends BaseDialog {
    public QuestDialog(final App app) {
        super(app, app.getLang().get("gui.dialog.quest.title"));

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
