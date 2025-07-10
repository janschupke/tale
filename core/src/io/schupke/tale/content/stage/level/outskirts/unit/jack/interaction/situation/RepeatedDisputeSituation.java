package io.schupke.tale.content.stage.level.outskirts.unit.jack.interaction.situation;

import io.schupke.tale.base.App;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Jack's dispute situation - repeated form.
 *
 * @author jan.schupke@gmail.com
 */
public class RepeatedDisputeSituation extends Situation {
    public RepeatedDisputeSituation(final App app) {
        super(app, app.getLang().get("level.outskirts.interaction.jack.dispute-retry.description"),
                SituationTags.OUTSKIRTS_JACK_DISPUTE_RETRY);

        decisions.add(new Decision(app.getLang().get("level.outskirts.interaction.jack.dispute-retry.decision.accept"),
                DecisionTags.OUTSKIRTS_JACK_DISPUTE_ACCEPT));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
