package eu.janschupke.tale.content.stage.level.settlement.unit.smith.interaction.situation;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Situation;

/**
 * Pedro guitar rambling situation.
 *
 * @author jan.schupke@gmail.com
 */
public class RamblingSituation extends Situation {
    public RamblingSituation(final App app) {
        super(app, app.getLang().get("level.settlement.interaction.smith.ramble.description"),
                SituationTags.SETTLEMENT_SMITH_RAMBLE);

        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
