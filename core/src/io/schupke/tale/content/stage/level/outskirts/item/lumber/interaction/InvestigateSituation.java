package io.schupke.tale.content.stage.level.outskirts.item.lumber.interaction;

import io.schupke.tale.base.App;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Initial lumber interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class InvestigateSituation extends Situation {
    public InvestigateSituation(final App app) {
        super(app, app.getLang().get("level.outskirts.interaction.lumber.investigate.description"),
                SituationTags.OUTSKIRTS_LUMBER_INVESTIGATE);
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.pickup"),
                DecisionTags.OUTSKIRTS_LUMBER_PICKUP));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.ignore"),
                DecisionTags.OUTSKIRTS_LUMBER_IGNORE));
    }
}
