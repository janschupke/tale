package io.schupke.tale.content.stage.level.outskirts.unit.jack.interaction.situation;

import io.schupke.tale.base.App;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Book retrieval failed.
 *
 * @author jan.schupke@gmail.com
 */
public class FailSituation extends Situation {
    public FailSituation(final App app) {
        super(app, app.getLang().get("level.outskirts.interaction.jack.fail.description"),
                SituationTags.OUTSKIRTS_JACK_FAIL);

        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
