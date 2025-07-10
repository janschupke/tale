package io.schupke.tale.content.stage.level.settlement.unit.chobo.interaction;

import io.schupke.tale.base.App;
import io.schupke.tale.base.entity.Triggerable;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.InteractionTags;
import io.schupke.tale.content.stage.level.settlement.event.SettlementEventHandler;
import io.schupke.tale.content.stage.level.settlement.unit.chobo.interaction.situation.*;

/**
 * Interaction class for the Chobo unit.
 *
 * @author jan.schupke@gmail.com
 */
public class ChoboInteraction extends Interaction {
    private Situation journalSituation;
    private Situation houseSituation;
    private Situation journalDeliveredSituation;
    private Situation keyDeliveredSituation;
    private Situation dungeonSituation;

    public ChoboInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.SETTLEMENT_CHOBO);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.settlement.interaction.chobo.title");
        Situation talkSituation = new TalkSituation(app);
        journalSituation = new JournalSituation(app);
        houseSituation = new HouseSituation(app);
        journalDeliveredSituation = new JournalDeliveredSituation(app);
        keyDeliveredSituation = new KeyDeliveredSituation(app);
        dungeonSituation = new DungeonSituation(app);
        situations.add(talkSituation);
        situations.add(journalSituation);
        situations.add(houseSituation);
        situations.add(journalDeliveredSituation);
        situations.add(keyDeliveredSituation);
        situations.add(dungeonSituation);
        currentSituation = talkSituation;
        fallbackSituation = talkSituation;
    }

    @Override
    public void handle(Decision decision) {
        if (decision.getTag().equals(DecisionTags.SETTLEMENT_CHOBO_HOUSE)) {
            ((SettlementEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler())
                    .getChoboDiscussHouseInteractionEvent().trigger();

            transition(houseSituation, app);
        } else if (decision.getTag().equals(DecisionTags.SETTLEMENT_CHOBO_DUNGEON)) {
            ((SettlementEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler())
                    .getChoboDungeonInteractionEvent().trigger();

            transition(dungeonSituation, app);
        } else if (decision.getTag().equals(DecisionTags.SETTLEMENT_CHOBO_KEY)) {
            ((SettlementEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler())
                    .getChoboKeyInteractionEvent().trigger();

            transition(keyDeliveredSituation, app);
        } else if (decision.getTag().equals(DecisionTags.SETTLEMENT_CHOBO_JOURNAL)) {
            ((SettlementEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler())
                    .getChoboJournalInteractionEvent().trigger();

            transition(journalSituation, app);
        } else if (decision.getTag().equals(DecisionTags.SETTLEMENT_CHOBO_JOURNAL_GIVE)) {
            ((SettlementEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler())
                    .getChoboJournalGiveInteractionEvent().trigger();

            transition(journalDeliveredSituation, app);
        } else {
            triggerable.endInteraction(app);
        }
    }
}
