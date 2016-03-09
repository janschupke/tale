package eu.janschupke.tale.content.stage.level.outskirts.unit.jack.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.interaction.Situation;

/**
 * Jack unit interaction class.
 *
 * @author jan.schupke@gmail.com
 */
public class JackInteraction extends Interaction {
    private Situation talkSituation;
    private Situation croneRamblingSituation;
    private Situation lumberRequestSituation;
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
        initialDisputeSituation = new InitialDisputeSituation(app);
        repeatedDisputeSituation = new RepeatedDisputeSituation(app);
        disputeAcceptedSituation = new DisputeAcceptedSituation(app);
        disputeDoneSituation = new DisputeDoneSituation(app);
        situations.add(talkSituation);
        situations.add(croneRamblingSituation);
        situations.add(lumberRequestSituation);
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
            // crone rambling
        } else if (decision.getTag().equals(DecisionTags.OUTSKIRTS_JACK_FOREST)) {
            // forest / lumber
        } else if (decision.getTag().equals(DecisionTags.OUTSKIRTS_JACK_LUMBER_ACCEPT)) {
            // lumber quest accepted
        } else if (decision.getTag().equals(DecisionTags.OUTSKIRTS_JACK_LUMBER_GIVE)) {
            // lumber given
        } else if (decision.getTag().equals(DecisionTags.OUTSKIRTS_JACK_DISPUTE)) {
            // dispute situation
        } else if (decision.getTag().equals(DecisionTags.OUTSKIRTS_JACK_DISPUTE_ACCEPT)) {
            // dispute accept
        } else if (decision.getTag().equals(DecisionTags.OUTSKIRTS_JACK_BOOK_GIVE)) {
            // book given, dispute done
        } else {
            triggerable.endInteraction(app);
        }
    }
}
