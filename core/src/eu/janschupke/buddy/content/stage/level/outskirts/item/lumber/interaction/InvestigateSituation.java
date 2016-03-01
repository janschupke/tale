package eu.janschupke.buddy.content.stage.level.outskirts.item.lumber.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.config.enumeration.tags.DecisionTags;
import eu.janschupke.buddy.framework.config.enumeration.tags.SituationTags;

/**
 * Initial lumber interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class InvestigateSituation extends Situation {
    public InvestigateSituation(final App app) {
        super(app, app.getLang().get("level.outskirts.interaction.lumber.investigate.description"),
                SituationTags.OUTSKIRTS_LUMBER_INVESTIGATE);
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"), DecisionTags.GLOBAL_END));
    }
}
