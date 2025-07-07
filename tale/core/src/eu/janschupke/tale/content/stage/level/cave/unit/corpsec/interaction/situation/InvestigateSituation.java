package eu.janschupke.tale.content.stage.level.cave.unit.corpsec.interaction.situation;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.interaction.Decision;
import eu.janschupke.tale.base.interaction.Situation;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;

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
