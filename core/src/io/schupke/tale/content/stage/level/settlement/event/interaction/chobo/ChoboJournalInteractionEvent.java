package io.schupke.tale.content.stage.level.settlement.event.interaction.chobo;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.quest.QuestChain;
import io.schupke.tale.base.container.quest.enumeration.TaskStatus;
import io.schupke.tale.base.event.InteractionEvent;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.Screens;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;
import io.schupke.tale.content.stage.level.cave.CaveScreen;
import io.schupke.tale.content.stage.level.cave.quest.CaveQuestManager;

/**
 * Journal is being discussed.
 *
 * @author jan.schupke@gmail.com
 */
public class ChoboJournalInteractionEvent extends InteractionEvent {
    public ChoboJournalInteractionEvent(final App app) {
        super(app);
    }

    @Override
    protected void updateMessages() {

    }

    @Override
    protected void updateQuests() {
        QuestChain chain = ((CaveQuestManager)((CaveScreen) app.getScreenInstance(Screens.CAVE))
                .getQuestManager()).getCorpsecQuestChain();
        if (!chain.getActiveQuest().getTasks().get(0).getStatus().equals(TaskStatus.DONE)) {
            chain.getActiveQuest().getTasks().get(0).setStatus(TaskStatus.DONE);
            chain.transition();
        }
    }

    @Override
    protected void updateGameState() {
        app.getGameLog().addEntry(GameEventTags.SETTLEMENT_INTERACTION_CHOBO_JOURNAL, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
