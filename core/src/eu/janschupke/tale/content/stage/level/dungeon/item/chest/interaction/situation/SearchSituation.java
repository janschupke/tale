package eu.janschupke.tale.content.stage.level.dungeon.item.chest.interaction.situation;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Situation;

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
