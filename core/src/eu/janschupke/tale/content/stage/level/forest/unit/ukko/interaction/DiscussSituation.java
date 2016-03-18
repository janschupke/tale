package eu.janschupke.tale.content.stage.level.forest.unit.ukko.interaction;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.interaction.Decision;
import eu.janschupke.tale.base.interaction.Situation;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Ukko's purpose discussion situation.
 *
 * @author jan.schupke@gmail.com
 */
public class DiscussSituation extends Situation {
    public DiscussSituation(final App app) {
        super(app, app.getLang().get("level.forest.interaction.ukko.discuss.description"),
                SituationTags.FOREST_UKKO_DISCUSS);

        decisions.add(new Decision(app.getLang().get("level.forest.interaction.ukko.discuss.decision.delivery"),
                DecisionTags.FOREST_UKKO_DELIVERY, false));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
