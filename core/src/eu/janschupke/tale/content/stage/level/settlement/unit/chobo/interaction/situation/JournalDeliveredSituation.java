package eu.janschupke.tale.content.stage.level.settlement.unit.chobo.interaction.situation;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Situation;

/**
 * Journal has been delivered.
 *
 * @author jan.schupke@gmail.com
 */
public class JournalDeliveredSituation extends Situation {
    public JournalDeliveredSituation(final App app) {
        super(app, app.getLang().get("level.settlement.interaction.chobo.journal-delivered.description"),
                SituationTags.SETTLEMENT_CHOBO_JOURNAL_DELIVERED);

        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
