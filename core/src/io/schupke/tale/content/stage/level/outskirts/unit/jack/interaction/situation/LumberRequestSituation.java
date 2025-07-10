package io.schupke.tale.content.stage.level.outskirts.unit.jack.interaction.situation;

import io.schupke.tale.base.App;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Jack's lumber request situation.
 *
 * @author jan.schupke@gmail.com
 */
public class LumberRequestSituation extends Situation {
    public LumberRequestSituation(final App app) {
        super(app, app.getLang().get("level.outskirts.interaction.jack.lumber-request.description"),
                SituationTags.OUTSKIRTS_JACK_LUMBER_REQUEST);

        decisions.add(new Decision(app.getLang().get("level.outskirts.interaction.jack.lumber-request.decision.accept"),
                DecisionTags.OUTSKIRTS_JACK_LUMBER_ACCEPT));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
