package eu.janschupke.tale.content.stage.level.settlement.unit.chobo.interaction.situation;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.interaction.Decision;
import eu.janschupke.tale.base.interaction.Situation;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Key has been delivered.
 *
 * @author jan.schupke@gmail.com
 */
public class KeyDeliveredSituation extends Situation {
    public KeyDeliveredSituation(final App app) {
        super(app, app.getLang().get("level.settlement.interaction.chobo.key-delivered.description"),
                SituationTags.SETTLEMENT_CHOBO_KEY_DELIVERED);

        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
