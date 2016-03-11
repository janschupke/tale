package eu.janschupke.tale.content.stage.level.settlement.obstacle.dungeon.interaction;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.interaction.Decision;
import eu.janschupke.tale.base.interaction.Situation;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Initial dungeon interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class InvestigateSituation extends Situation {
    public InvestigateSituation(final App app) {
        super(app, app.getLang().get("level.settlement.interaction.dungeon.investigate.description"),
                SituationTags.SETTLEMENT_DUNGEON_INVESTIGATE);

        decisions.add(new Decision(app.getLang().get("level.settlement.interaction.dungeon.investigate.decision.enter"),
                DecisionTags.SETTLEMENT_DUNGEON_ENTER));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
