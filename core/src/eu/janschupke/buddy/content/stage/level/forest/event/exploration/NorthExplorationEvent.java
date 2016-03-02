package eu.janschupke.buddy.content.stage.level.forest.event.exploration;

import eu.janschupke.buddy.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.ExplorationEvent;
import eu.janschupke.buddy.framework.base.screen.BaseScreen;
import eu.janschupke.buddy.framework.base.ui.dialog.InfoDialog;

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
    }

    @Override
    protected void updateMessages() {
        showDialog(explorationDialog);
        addEventMessage();
    }

    @Override
    protected void updateQuests() {

    }

    @Override
    protected void updateGameState() {
        app.getGameLog().addEntry(GameEventTags.FOREST_NORTH_EXPLORATION, ((BaseScreen)app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
