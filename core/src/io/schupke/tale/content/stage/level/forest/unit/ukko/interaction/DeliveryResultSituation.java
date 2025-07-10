package io.schupke.tale.content.stage.level.forest.unit.ukko.interaction;

import io.schupke.tale.base.App;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Situation that occurs right after the coin delivery.
 *
 * @author jan.schupke@gmail.com
 */
public class DeliveryResultSituation extends Situation {
    public DeliveryResultSituation(final App app) {
        super(app, app.getLang().get("level.forest.interaction.ukko.delivery-result.description"),
                SituationTags.FOREST_UKKO_DELIVERY_RESULT);

        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
