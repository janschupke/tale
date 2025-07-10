package io.schupke.tale.content.stage.level.dungeon.event.general;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.GeneralEvent;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.base.ui.dialog.InfoDialog;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Event for warning about dungeon exit.
 * Handles exit warnings and confirmation dialogs.
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
