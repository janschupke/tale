package eu.janschupke.tale.content.stage.level.forest.event.exploration;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.event.ExplorationEvent;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.base.ui.dialog.InfoDialog;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;

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
