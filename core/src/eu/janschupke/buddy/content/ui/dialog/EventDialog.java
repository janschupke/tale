package eu.janschupke.buddy.content.ui.dialog;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.BaseDialog;

/**
 * Dialog window containing printout of all in-game events.
 */
public class EventDialog extends BaseDialog {
    private Label textArea;

    public EventDialog(final App app) {
        super(app, app.getLang().get("gui.dialog.event.title"));

        initWidgets();
        addWidgets();
        setListeners();
        setMovable(true);
        setModal(false);
        pack();
    }

    @Override
    protected void result(Object object) {
        hide();
    }

    @Override
    public void initWidgets() {
        button(app.getLang().get("menu.global.button.close"), true);
        textArea = new Label("", app.getSkin());
    }

    @Override
    public void addWidgets() {
        getContentTable().add(textArea);
    }

    @Override
    public void setListeners() {}

    @Override
    public Dialog show(Stage stage) {
        return super.show(stage);
    }

    @Override
    public void cancel() {
        super.cancel();
    }

    public void addEvent(String event) {
        textArea.setText(textArea.getText() + "\n" + event);
    }
}
