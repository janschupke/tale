package io.schupke.tale.content.stage.level.forest.event.exploration;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.ExplorationEvent;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.base.ui.dialog.InfoDialog;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Exploration event for the north optional area.
 *
 * @author jan.schupke@gmail.com
 */
public class NorthExplorationEvent extends ExplorationEvent {
    private class ExplorationDialog extends InfoDialog {
        public ExplorationDialog(final App app) {
            super(app, app.getLang().get("level.forest.dialog.exploration-north.title"));
            label.setText(app.getLang().get("level.forest.event.exploration-north.text"));
        }
    }

    private ExplorationDialog explorationDialog;

    public NorthExplorationEvent(final App app) {
        super(app, app.getLang().get("level.forest.event.exploration-north.text"));
        explorationDialog = new ExplorationDialog(app);
//        withDialog = true;
    }

    @Override
    protected void updateMessages() {
//        showDialog(explorationDialog);
        addEventMessage();
        app.getGameState().getGlobalLevelState().setNewEvent(true);
    }

    @Override
    protected void updateQuests() {

    }

    @Override
    protected void updateGameState() {
        app.getGameLog().addEntry(GameEventTags.FOREST_EXPLORATION_NORTH, ((BaseScreen)app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
