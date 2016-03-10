package eu.janschupke.tale.content.stage.level.settlement.unit.chobo.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.stage.level.settlement.event.SettlementEventHandler;
import eu.janschupke.tale.content.stage.level.settlement.unit.chobo.interaction.situation.*;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.interaction.Situation;
import eu.janschupke.tale.framework.screen.GameScreen;

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
        situations.add(talkSituation);
        situations.add(journalSituation);
        situations.add(houseSituation);
        situations.add(journalDeliveredSituation);
        situations.add(keyDeliveredSituation);
        currentSituation = talkSituation;
        fallbackSituation = talkSituation;
    }

    @Override
    public void handle(Decision decision) {
        if (decision.getTag().equals(DecisionTags.SETTLEMENT_CHOBO_HOUSE)) {
            ((SettlementEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler())
                    .getChoboDiscussHouseInteractionEvent().trigger();

            transition(houseSituation, app);
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
