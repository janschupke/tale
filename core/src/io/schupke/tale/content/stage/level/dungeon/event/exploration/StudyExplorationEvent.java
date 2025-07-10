package io.schupke.tale.content.stage.level.dungeon.event.exploration;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.ExplorationEvent;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.base.ui.dialog.InfoDialog;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Event for studying objects in the dungeon.
 * Handles exploration and discovery mechanics.
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
