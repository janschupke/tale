package eu.janschupke.tale.content.stage.level.dungeon.event.exploration;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.event.ExplorationEvent;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.base.ui.dialog.InfoDialog;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Exploration event for the study area.
 *
 * @author jan.schupke@gmail.com
 */
public class StudyExplorationEvent extends ExplorationEvent {
    class StudyExplorationDialog extends InfoDialog {
        public StudyExplorationDialog(final App app) {
            super(app, app.getLang().get("level.dungeon.dialog.study-exploration.title"));
            label.setText(app.getLang().get("level.dungeon.event.study-exploration.text"));
        }
    }

    private StudyExplorationDialog studyExplorationDialog;

    public StudyExplorationEvent(final App app) {
        super(app, app.getLang().get("level.dungeon.event.study-exploration.text"));
        studyExplorationDialog = new StudyExplorationDialog(app);
//        withDialog = true;
    }

    @Override
    protected void updateMessages() {
//        showDialog(studyExplorationDialog);
//        addEventMessage();
    }

    @Override
    protected void updateQuests() {

    }

    @Override
    protected void updateGameState() {
        app.getGameLog().addEntry(GameEventTags.DUNGEON_EXPLORATION_STUDY, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
