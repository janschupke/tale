package eu.janschupke.buddy.content.stage.level.forest.event.general;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.GeneralEvent;
import eu.janschupke.buddy.framework.base.screen.BaseScreen;
import eu.janschupke.buddy.framework.base.ui.dialog.InfoDialog;
import eu.janschupke.buddy.framework.config.enumeration.tags.GameEventTags;

/**
 * An event triggered by trying to proceed to the next part of the world
 * before picking up the coin.
 *
 * @author jan.schupke@gmail.com
 */
public class InitialWallGeneralEvent extends GeneralEvent {
    private InitialWallDialog initialWallDialog;

    public InitialWallGeneralEvent(final App app) {
        super(app, app.getLang().get("level.forest.event.wall.init.text"));
        repeatable = true;
        initialWallDialog = new InitialWallDialog(app);
    }

    @Override
    protected void updateMessages() {
        showDialog(initialWallDialog);
        addEventMessage();
    }

    @Override
    protected void updateQuests() {

    }

    @Override
    protected void updateGameState() {
        app.getGameLog().addEntry(GameEventTags.FOREST_INITIAL_WALL_CONTACT, ((BaseScreen)app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }

    /**
     * Initial wall message dialog.
     */
    class InitialWallDialog extends InfoDialog {
        public InitialWallDialog(final App app) {
            super(app, app.getLang().get("level.forest.dialog.wall.init.title"));
            label.setText(app.getLang().get("level.forest.event.wall.init.text"));
        }
    }
}
