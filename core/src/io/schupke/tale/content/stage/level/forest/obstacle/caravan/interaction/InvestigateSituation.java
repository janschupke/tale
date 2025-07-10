package io.schupke.tale.content.stage.level.forest.obstacle.caravan.interaction;

import io.schupke.tale.base.App;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Initial caravan interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class InvestigateSituation extends Situation {
    public InvestigateSituation(final App app) {
        super(app, app.getLang().get("level.forest.interaction.caravan.investigate.description"),
                SituationTags.FOREST_CARAVAN_INVESTIGATE);
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"), DecisionTags.GLOBAL_END));
    }
}
