package eu.janschupke.buddy.content.stage.level.settlement.obstacle.dungeon.interaction;

import eu.janschupke.buddy.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.buddy.content.config.enumeration.tags.SituationTags;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Situation;

/**
 * Initial dungeon interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class InvestigateSituation extends Situation {
    public InvestigateSituation(final App app) {
        super(app, app.getLang().get("level.settlement.interaction.dungeon.investigate.description"),
                SituationTags.SETTLEMENT_DUNGEON_INVESTIGATE);
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"), DecisionTags.GLOBAL_END));
    }
}
