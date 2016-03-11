package eu.janschupke.tale.content.stage.level.outskirts.unit.jack.interaction.situation;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.interaction.Decision;
import eu.janschupke.tale.base.interaction.Situation;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Jack's dispute situation - initial form.
 *
 * @author jan.schupke@gmail.com
 */
public class InitialDisputeSituation extends Situation {
    public InitialDisputeSituation(final App app) {
        super(app, app.getLang().get("level.outskirts.interaction.jack.dispute-init.description"),
                SituationTags.OUTSKIRTS_JACK_DISPUTE_INIT);

        decisions.add(new Decision(app.getLang().get("level.outskirts.interaction.jack.dispute-init.decision.accept"),
                DecisionTags.OUTSKIRTS_JACK_DISPUTE_ACCEPT));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
