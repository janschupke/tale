package io.schupke.tale.content.stage.level.settlement.unit.chobo.interaction.situation;

import io.schupke.tale.base.App;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Journal discussion situation.
 *
 * @author jan.schupke@gmail.com
 */
public class JournalSituation extends Situation {
    public JournalSituation(final App app) {
        super(app, app.getLang().get("level.settlement.interaction.chobo.journal.description"),
                SituationTags.SETTLEMENT_CHOBO_JOURNAL);

        decisions.add(new Decision(app.getLang().get("level.settlement.interaction.chobo.journal.decision.give"),
                DecisionTags.SETTLEMENT_CHOBO_JOURNAL_GIVE));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
