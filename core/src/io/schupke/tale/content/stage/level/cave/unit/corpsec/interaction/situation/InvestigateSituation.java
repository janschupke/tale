package io.schupke.tale.content.stage.level.cave.unit.corpsec.interaction.situation;

import io.schupke.tale.base.App;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Initial cave Corpssec interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class InvestigateSituation extends Situation {
    public InvestigateSituation(final App app) {
        super(app, app.getLang().get("level.cave.interaction.corpsec.investigate.description"),
                SituationTags.CAVE_CORPSEC_INVESTIGATE);

        decisions.add(new Decision(app.getLang().get("level.cave.interaction.corpsec.investigate.decision.search"),
                DecisionTags.CAVE_CORPSEC_INVESTIGATE_SEARCH));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
