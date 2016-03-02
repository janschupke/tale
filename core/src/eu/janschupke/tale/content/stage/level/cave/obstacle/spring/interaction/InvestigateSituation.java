package eu.janschupke.tale.content.stage.level.cave.obstacle.spring.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.base.interaction.Decision;
import eu.janschupke.tale.framework.base.interaction.Situation;

/**
 * Initial cave spring interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class InvestigateSituation extends Situation {
    public InvestigateSituation(final App app) {
        super(app, app.getLang().get("level.cave.interaction.spring.investigate.description"),
                SituationTags.CAVE_SPRING_INVESTIGATE);
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"), DecisionTags.GLOBAL_END));
    }
}
