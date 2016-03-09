package eu.janschupke.tale.content.stage.level.forest.unit.ukko.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Situation;

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