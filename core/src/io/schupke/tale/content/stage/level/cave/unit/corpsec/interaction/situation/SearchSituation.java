package io.schupke.tale.content.stage.level.cave.unit.corpsec.interaction.situation;

import io.schupke.tale.base.App;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Searching for items.
 *
 * @author jan.schupke@gmail.com
 */
public class SearchSituation extends Situation {
    public SearchSituation(final App app) {
        super(app, app.getLang().get("level.cave.interaction.corpsec.search.description"), SituationTags.CAVE_CORPSEC_SEARCH);

        decisions.add(new Decision(app.getLang().get("level.cave.interaction.corpsec.search.decision.loot"),
                DecisionTags.CAVE_CORPSEC_SEARCH_LOOT));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
