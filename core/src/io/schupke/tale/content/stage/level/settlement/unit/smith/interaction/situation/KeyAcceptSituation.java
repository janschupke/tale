package io.schupke.tale.content.stage.level.settlement.unit.smith.interaction.situation;

import io.schupke.tale.base.App;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Key delivery quest accepted.
 *
 * @author jan.schupke@gmail.com
 */
public class KeyAcceptSituation extends Situation {
    public KeyAcceptSituation(final App app) {
        super(app, app.getLang().get("level.settlement.interaction.smith.key-accept.description"),
                SituationTags.SETTLEMENT_SMITH_ACCEPT);

        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
