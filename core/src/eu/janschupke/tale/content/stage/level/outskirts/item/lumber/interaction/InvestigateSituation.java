package eu.janschupke.tale.content.stage.level.outskirts.item.lumber.interaction;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.interaction.Decision;
import eu.janschupke.tale.base.interaction.Situation;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Initial lumber interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class InvestigateSituation extends Situation {
    public InvestigateSituation(final App app) {
        super(app, app.getLang().get("level.outskirts.interaction.lumber.investigate.description"),
                SituationTags.OUTSKIRTS_LUMBER_INVESTIGATE);
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.pickup"),
                DecisionTags.OUTSKIRTS_LUMBER_PICKUP));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.ignore"),
                DecisionTags.OUTSKIRTS_LUMBER_IGNORE));
    }
}
