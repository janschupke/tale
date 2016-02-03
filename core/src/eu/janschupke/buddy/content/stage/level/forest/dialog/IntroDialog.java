package eu.janschupke.buddy.content.stage.level.forest.dialog;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.BaseDialog;

/**
 * Introduction dialog.
 */
public class IntroDialog extends BaseDialog {
    private Label label;

    public IntroDialog(final App app) {
        super(app, app.getLang().get("level.forest.dialog.intro.title"));

        label = new Label(app.getLang().get("level.forest.event.intro.text"), app.getSkin());
        label.setAlignment(Align.center);

        button(app.getLang().get("menu.global.button.close"), true);
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
