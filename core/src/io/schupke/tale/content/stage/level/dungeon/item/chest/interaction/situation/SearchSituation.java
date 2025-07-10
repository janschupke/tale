package io.schupke.tale.content.stage.level.dungeon.item.chest.interaction.situation;

import io.schupke.tale.base.App;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Chest searching.
 *
 * @author jan.schupke@gmail.com
 */
public class SearchSituation extends Situation {
    public SearchSituation(final App app) {
        super(app, app.getLang().get("level.dungeon.interaction.chest.search.description"),
                SituationTags.DUNGEON_CHEST_SEARCH);

        decisions.add(new Decision(app.getLang().get("level.dungeon.interaction.chest.search.decision.collect"),
                DecisionTags.DUNGEON_CHEST_COLLECT));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
