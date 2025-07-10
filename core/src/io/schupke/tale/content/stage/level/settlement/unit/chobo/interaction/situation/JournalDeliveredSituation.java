package io.schupke.tale.content.stage.level.settlement.unit.chobo.interaction.situation;

import io.schupke.tale.base.App;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

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
