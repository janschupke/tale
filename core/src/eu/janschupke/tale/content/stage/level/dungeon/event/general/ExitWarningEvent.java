package eu.janschupke.tale.content.stage.level.dungeon.event.general;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.event.GeneralEvent;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.base.ui.dialog.InfoDialog;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Game end approaching warning event.
 *
 * @author jan.schupke@gmail.com
 */
public class ExitWarningEvent extends GeneralEvent {
    private WarningDialog warningDialog;

    class WarningDialog extends InfoDialog {
        public WarningDialog(final App app) {
            super(app, app.getLang().get("level.dungeon.dialog.exit-warning.title"));
            label.setText(app.getLang().get("level.dungeon.event.exit-warning.text"));
        }
    }

    public ExitWarningEvent(final App app) {
        super(app, app.getLang().get("level.dungeon.event.exit-warning.text"));
        warningDialog = new WarningDialog(app);
        withDialog = true;
        repeatable = false;
    }

    @Override
    protected void updateMessages() {
        showDialog(warningDialog);
        addEventMessage();
    }

    @Override
    protected void updateQuests() {

    }

    @Override
    protected void updateGameState() {
        app.getGameLog().addEntry(GameEventTags.DUNGEON_GENERAL_EXIT_WARNING, ((BaseScreen)app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
