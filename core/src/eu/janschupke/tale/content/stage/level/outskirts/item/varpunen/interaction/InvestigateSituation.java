package eu.janschupke.tale.content.stage.level.outskirts.item.varpunen.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Situation;

/**
 * Initial varpunen note interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class InvestigateSituation extends Situation {
    public InvestigateSituation(final App app) {
        super(app, app.getLang().get("level.outskirts.interaction.varpunen.investigate.description"),
                SituationTags.OUTSKIRTS_VARPUNEN_INVESTIGATE);
        decisions.add(new Decision(app.getLang().get("level.outskirts.interaction.varpunen.pickup.decision.pickup"),
                DecisionTags.OUTSKIRTS_VARPUNEN_PICKUP));
        decisions.add(new Decision(app.getLang().get("level.outskirts.interaction.varpunen.pickup.decision.ignore"),
                DecisionTags.OUTSKIRTS_VARPUNEN_IGNORE));
    }
}