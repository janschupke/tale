package eu.janschupke.tale.content.stage.level.settlement.unit.smith.interaction;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.entity.Triggerable;
import eu.janschupke.tale.base.interaction.Decision;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.interaction.Situation;
import eu.janschupke.tale.base.screen.GameScreen;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.stage.level.settlement.event.SettlementEventHandler;
import eu.janschupke.tale.content.stage.level.settlement.unit.smith.interaction.situation.AssistanceInquirySituation;
import eu.janschupke.tale.content.stage.level.settlement.unit.smith.interaction.situation.KeyAcceptSituation;
import eu.janschupke.tale.content.stage.level.settlement.unit.smith.interaction.situation.RamblingSituation;
import eu.janschupke.tale.content.stage.level.settlement.unit.smith.interaction.situation.TalkSituation;

/**
 * Interaction class for the Smith unit.
 * Manages conversations and interactions with the blacksmith character.
 */
public class SmithInteraction extends Interaction {
    private Situation assistanceInquirySituation;
    private Situation keyAcceptSituation;
    private Situation ramblingSituation;

    public SmithInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.SETTLEMENT_SMITH);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.settlement.interaction.smith.title");
        Situation talkSituation = new TalkSituation(app);
        assistanceInquirySituation = new AssistanceInquirySituation(app);
        keyAcceptSituation = new KeyAcceptSituation(app);
        ramblingSituation = new RamblingSituation(app);
        situations.add(talkSituation);
        situations.add(assistanceInquirySituation);
        situations.add(keyAcceptSituation);
        situations.add(ramblingSituation);
        currentSituation = talkSituation;
        fallbackSituation = talkSituation;
    }

    @Override
    public void handle(Decision decision) {
        if (decision.getTag().equals(DecisionTags.SETTLEMENT_SMITH_ASSISTANCE)) {
            ((SettlementEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler())
                    .getSmithAssistanceInteractionEvent().trigger();
            transition(assistanceInquirySituation,app);
        } else if (decision.getTag().equals(DecisionTags.SETTLEMENT_SMITH_RAMBLING)) {
            ((SettlementEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler())
                    .getSmithRamblingInteractionEvent().trigger();
            transition(ramblingSituation, app);
        } else if (decision.getTag().equals(DecisionTags.SETTLEMENT_SMITH_ACCEPT)) {
            ((SettlementEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler())
                    .getSmithKeyAcceptInteractionEvent().trigger();
            transition(keyAcceptSituation, app);
        } else {
            triggerable.endInteraction(app);
        }
    }
}
