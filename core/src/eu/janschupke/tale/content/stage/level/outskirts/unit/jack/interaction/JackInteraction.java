package eu.janschupke.tale.content.stage.level.outskirts.unit.jack.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.stage.level.outskirts.OutskirtsEventHandler;
import eu.janschupke.tale.content.stage.level.outskirts.unit.jack.interaction.situation.*;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.interaction.Situation;
import eu.janschupke.tale.framework.screen.GameScreen;

/**
 * Jack unit interaction class.
 *
 * @author jan.schupke@gmail.com
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
        situations.add(talkSituation);
        situations.add(croneRamblingSituation);
        situations.add(lumberRequestSituation);
        situations.add(lumberAcceptedSituation);
        situations.add(initialDisputeSituation);
        situations.add(repeatedDisputeSituation);
        situations.add(disputeAcceptedSituation);
        situations.add(disputeDoneSituation);
        currentSituation = talkSituation;
        fallbackSituation = talkSituation;
    }

    @Override
    public void handle(Decision decision) {
        if (decision.getTag().equals(DecisionTags.OUTSKIRTS_JACK_CRONE)) {
            // TODO: log?
            transition(croneRamblingSituation, app);
        } else if (decision.getTag().equals(DecisionTags.OUTSKIRTS_JACK_FOREST)) {
            // TODO: log?
            transition(lumberRequestSituation, app);
        } else if (decision.getTag().equals(DecisionTags.OUTSKIRTS_JACK_LUMBER_ACCEPT)) {
            ((OutskirtsEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getJackLumberAcceptInteractionEvent().trigger();
            transition(lumberAcceptedSituation, app);
        } else if (decision.getTag().equals(DecisionTags.OUTSKIRTS_JACK_LUMBER_GIVE)) {
            ((OutskirtsEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getJackLumberGiveInteractionEvent().trigger();
            transition(initialDisputeSituation, app);
        } else if (decision.getTag().equals(DecisionTags.OUTSKIRTS_JACK_DISPUTE)) {
            // TODO: log?
            transition(repeatedDisputeSituation, app);
        } else if (decision.getTag().equals(DecisionTags.OUTSKIRTS_JACK_DISPUTE_ACCEPT)) {
            ((OutskirtsEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getJackDisputeAcceptInteractionEvent().trigger();
            transition(disputeAcceptedSituation, app);
        } else if (decision.getTag().equals(DecisionTags.OUTSKIRTS_JACK_BOOK_GIVE)) {
            ((OutskirtsEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getJackDisputeSolveInteractionEvent().trigger();
            transition(disputeDoneSituation, app);
        } else {
            triggerable.endInteraction(app);
        }
    }
}
