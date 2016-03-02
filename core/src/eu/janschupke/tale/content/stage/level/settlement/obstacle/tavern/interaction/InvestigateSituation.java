package eu.janschupke.tale.content.stage.level.settlement.obstacle.tavern.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.base.interaction.Decision;
import eu.janschupke.tale.framework.base.interaction.Situation;

/**
 * Initial blacksmith interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class InvestigateSituation extends Situation {
    public InvestigateSituation(final App app) {
        super(app, app.getLang().get("level.settlement.interaction.tavern.investigate.description"),
                SituationTags.SETTLEMENT_TAVERN_INVESTIGATE);
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"), DecisionTags.GLOBAL_END));
    }
}
