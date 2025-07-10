package io.schupke.tale.content.stage.level.settlement.unit.smith.interaction.situation;

import io.schupke.tale.base.App;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Initial Smith interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class TalkSituation extends Situation {
    public TalkSituation(final App app) {
        super(app, app.getLang().get("level.settlement.interaction.smith.talk.description"),
                SituationTags.SETTLEMENT_SMITH_TALK);

        decisions.add(new Decision(app.getLang().get("level.settlement.interaction.smith.talk.decision.rambling"),
                DecisionTags.SETTLEMENT_SMITH_RAMBLING));
        decisions.add(new Decision(app.getLang().get("level.settlement.interaction.smith.talk.decision.assistance"),
                DecisionTags.SETTLEMENT_SMITH_ASSISTANCE));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
