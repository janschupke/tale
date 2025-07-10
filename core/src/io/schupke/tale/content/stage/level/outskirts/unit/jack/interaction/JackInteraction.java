package io.schupke.tale.content.stage.level.outskirts.unit.jack.interaction;

import io.schupke.tale.base.App;
import io.schupke.tale.base.entity.Triggerable;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.InteractionTags;
import io.schupke.tale.content.stage.level.outskirts.event.OutskirtsEventHandler;
import io.schupke.tale.content.stage.level.outskirts.unit.jack.interaction.situation.CroneRamblingSituation;
import io.schupke.tale.content.stage.level.outskirts.unit.jack.interaction.situation.DisputeAcceptedSituation;
import io.schupke.tale.content.stage.level.outskirts.unit.jack.interaction.situation.DisputeDoneSituation;
import io.schupke.tale.content.stage.level.outskirts.unit.jack.interaction.situation.FailSituation;
import io.schupke.tale.content.stage.level.outskirts.unit.jack.interaction.situation.InitialDisputeSituation;
import io.schupke.tale.content.stage.level.outskirts.unit.jack.interaction.situation.LumberAcceptedSituation;
import io.schupke.tale.content.stage.level.outskirts.unit.jack.interaction.situation.LumberRequestSituation;
import io.schupke.tale.content.stage.level.outskirts.unit.jack.interaction.situation.RepeatedDisputeSituation;
import io.schupke.tale.content.stage.level.outskirts.unit.jack.interaction.situation.TalkSituation;

/**
 * Jack unit interaction class.
 * Manages conversations and interactions with the Jack character.
 */
public class JackInteraction extends Interaction {
    private Situation talkSituation;
    private Situation croneRamblingSituation;
    private Situation lumberRequestSituation;
    private Situation lumberAcceptedSituation;
    private Situation initialDisputeSituation;
    private Situation repeatedDisputeSituation;
    private Situation disputeAcceptedSituation;
    private Situation disputeDoneSituation;
    private Situation failSituation;

    public JackInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.OUTSKIRTS_JACK);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.outskirts.interaction.jack.title");
        talkSituation = new TalkSituation(app);
        croneRamblingSituation = new CroneRamblingSituation(app);
        lumberRequestSituation = new LumberRequestSituation(app);
        lumberAcceptedSituation = new LumberAcceptedSituation(app);
        initialDisputeSituation = new InitialDisputeSituation(app);
        repeatedDisputeSituation = new RepeatedDisputeSituation(app);
        disputeAcceptedSituation = new DisputeAcceptedSituation(app);
        disputeDoneSituation = new DisputeDoneSituation(app);
        failSituation = new FailSituation(app);
        situations.add(talkSituation);
        situations.add(croneRamblingSituation);
        situations.add(lumberRequestSituation);
        situations.add(lumberAcceptedSituation);
        situations.add(initialDisputeSituation);
        situations.add(repeatedDisputeSituation);
        situations.add(disputeAcceptedSituation);
        situations.add(disputeDoneSituation);
        situations.add(failSituation);
        currentSituation = talkSituation;
        fallbackSituation = talkSituation;
    }

    @Override
    public void handle(Decision decision) {
        if (decision.getTag().equals(DecisionTags.OUTSKIRTS_JACK_TALK_CRONE)) {
            ((OutskirtsEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getJackCroneInteractionEvent().trigger();
            transition(croneRamblingSituation, app);
        } else if (decision.getTag().equals(DecisionTags.OUTSKIRTS_JACK_TALK_FOREST)) {
            ((OutskirtsEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getJackLumberRequestInteractionEvent().trigger();
            transition(lumberRequestSituation, app);
        } else if (decision.getTag().equals(DecisionTags.OUTSKIRTS_JACK_LUMBER_ACCEPT)) {
            ((OutskirtsEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getJackLumberAcceptInteractionEvent().trigger();
            transition(lumberAcceptedSituation, app);
        } else if (decision.getTag().equals(DecisionTags.OUTSKIRTS_JACK_LUMBER_GIVE)) {
            ((OutskirtsEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getJackLumberGiveInteractionEvent().trigger();
            transition(initialDisputeSituation, app);
        } else if (decision.getTag().equals(DecisionTags.OUTSKIRTS_JACK_TALK_DISPUTE)) {
            ((OutskirtsEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getJackDisputeRequestInteractionEvent().trigger();
            transition(repeatedDisputeSituation, app);
        } else if (decision.getTag().equals(DecisionTags.OUTSKIRTS_JACK_DISPUTE_ACCEPT)) {
            ((OutskirtsEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getJackDisputeAcceptInteractionEvent().trigger();
            transition(disputeAcceptedSituation, app);
        } else if (decision.getTag().equals(DecisionTags.OUTSKIRTS_JACK_TALK_BOOK_GIVE)) {
            ((OutskirtsEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getJackDisputeSolveInteractionEvent().trigger();
            transition(disputeDoneSituation, app);
        } else if (decision.getTag().equals(DecisionTags.OUTSKIRTS_JACK_TALK_FAIL)) {
            ((OutskirtsEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getJackFailInteractionEvent().trigger();
            transition(failSituation, app);
        } else {
            triggerable.endInteraction(app);
        }
    }
}
