package eu.janschupke.tale.content.stage.level.settlement.unit.chobo.interaction.situation;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Situation;

/**
 * House discussion situation.
 *
 * @author jan.schupke@gmail.com
 */
public class HouseSituation extends Situation {
    public HouseSituation(final App app) {
        super(app, app.getLang().get("level.settlement.interaction.chobo.house.description"),
                SituationTags.SETTLEMENT_CHOBO_HOUSE);

        decisions.add(new Decision(app.getLang().get("level.settlement.interaction.chobo.house.decision.key"),
                DecisionTags.SETTLEMENT_CHOBO_KEY, false));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
