package eu.janschupke.tale.content.stage.level.outskirts.obstacle.cave.interaction;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.interaction.Decision;
import eu.janschupke.tale.base.interaction.Situation;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Initial cave interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class InvestigateSituation extends Situation {
    public InvestigateSituation(final App app) {
        super(app, app.getLang().get("level.outskirts.interaction.cave.investigate.description"),
                SituationTags.OUTSKIRTS_CAVE_INVESTIGATE);

        decisions.add(new Decision(app.getLang().get("level.outskirts.interaction.cave.investigate.decision.enter"),
                DecisionTags.OUTSKIRTS_CAVE_ENTER));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
