package io.schupke.tale.content.stage.level.settlement.unit.chobo.interaction.situation;

import io.schupke.tale.base.App;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Dungeon rambling situation.
 *
 * @author jan.schupke@gmail.com
 */
public class DungeonSituation extends Situation {
    public DungeonSituation(final App app) {
        super(app, app.getLang().get("level.settlement.interaction.chobo.dungeon.description"),
                SituationTags.SETTLEMENT_CHOBO_DUNGEON);

        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
