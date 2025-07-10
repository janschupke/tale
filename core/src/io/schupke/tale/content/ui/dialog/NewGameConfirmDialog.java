package io.schupke.tale.content.ui.dialog;

import com.badlogic.gdx.Gdx;
import io.schupke.tale.base.App;
import io.schupke.tale.base.ui.dialog.ConfirmDialog;
import io.schupke.tale.logging.utility.GameLogParser;

/**
 * A confirmation dialog for deleting an existing game state
 * and starting a new game.
 *
 * @author jan.schupke@gmail.com
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
            GameLogParser.parseToXml(app.getGameLog());
            app.resetState();
            app.getScreen().resume();
            app.getEventHandler().fireNewGame();
        } else {
            remove();
        }
    }
}
