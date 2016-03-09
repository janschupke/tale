package eu.janschupke.tale.content.stage.level.settlement.obstacle.farm.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Situation;

/**
 * Initial blacksmith interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class InvestigateSituation extends Situation {
    public InvestigateSituation(final App app) {
        super(app, app.getLang().get("level.settlement.interaction.farm.investigate.description"),
                SituationTags.SETTLEMENT_FARM_INVESTIGATE);
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"), DecisionTags.GLOBAL_END));
    }
}