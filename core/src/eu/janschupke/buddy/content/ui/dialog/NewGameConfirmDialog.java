package eu.janschupke.buddy.content.ui.dialog;

import com.badlogic.gdx.Gdx;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.dialog.ConfirmDialog;

/**
 * A confirmation dialog for deleting an existing game state
 * and starting a new game.
 */
public class NewGameConfirmDialog extends ConfirmDialog {
    public NewGameConfirmDialog(final App app) {
    super(app, app.getLang().get("menu.dialog.new-game.title"));

    label.setText(app.getLang().get("menu.dialog.new-game.text"));
}

    @Override
    protected void result(Object object) {
        boolean result = (Boolean) object;

        if (result) {
            Gdx.app.debug("NewGameConfirmDialog#result", "True");
            app.resetState();
            app.getScreen().resume();
            app.getEventHandler().fireNewGame();
        } else {
            remove();
        }
    }
}
