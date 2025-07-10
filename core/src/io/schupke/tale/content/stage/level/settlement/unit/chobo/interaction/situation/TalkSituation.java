package io.schupke.tale.content.stage.level.settlement.unit.chobo.interaction.situation;

import io.schupke.tale.base.App;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Initial Chobo interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class TalkSituation extends Situation {
    public TalkSituation(final App app) {
        super(app, app.getLang().get("level.settlement.interaction.chobo.talk.description"),
                SituationTags.SETTLEMENT_CHOBO_TALK);

        decisions.add(new Decision(app.getLang().get("level.settlement.interaction.chobo.talk.decision.dungeon"),
                DecisionTags.SETTLEMENT_CHOBO_DUNGEON));
        decisions.add(new Decision(app.getLang().get("level.settlement.interaction.chobo.talk.decision.journal"),
                DecisionTags.SETTLEMENT_CHOBO_JOURNAL, false));
        decisions.add(new Decision(app.getLang().get("level.settlement.interaction.chobo.talk.decision.house"),
                DecisionTags.SETTLEMENT_CHOBO_HOUSE));
        decisions.add(new Decision(app.getLang().get("level.settlement.interaction.chobo.talk.decision.key"),
                DecisionTags.SETTLEMENT_CHOBO_KEY, false));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
