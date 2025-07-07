package eu.janschupke.tale.content.stage.level.settlement.unit.smith.interaction.situation;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.interaction.Decision;
import eu.janschupke.tale.base.interaction.Situation;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Inquiring for assistance.
 *
 * @author jan.schupke@gmail.com
 */
public class AssistanceInquirySituation extends Situation {
    public AssistanceInquirySituation(final App app) {
        super(app, app.getLang().get("level.settlement.interaction.smith.assistance.description"),
                SituationTags.SETTLEMENT_SMITH_ASSISTANCE);

        decisions.add(new Decision(app.getLang().get("level.settlement.interaction.smith.assistance.decision.accept"),
                DecisionTags.SETTLEMENT_SMITH_ACCEPT));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
