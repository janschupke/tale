package io.schupke.tale.content.stage.level.forest.unit.ukko.interaction;

import io.schupke.tale.base.App;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Ukko's purpose discussion situation.
 *
 * @author jan.schupke@gmail.com
 */
public class DiscussSituation extends Situation {
    public DiscussSituation(final App app) {
        super(app, app.getLang().get("level.forest.interaction.ukko.discuss.description"),
                SituationTags.FOREST_UKKO_DISCUSS);

        decisions.add(new Decision(app.getLang().get("level.forest.interaction.ukko.discuss.decision.delivery"),
                DecisionTags.FOREST_UKKO_DELIVERY, false));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
