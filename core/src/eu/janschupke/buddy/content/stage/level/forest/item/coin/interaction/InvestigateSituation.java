package eu.janschupke.buddy.content.stage.level.forest.item.coin.interaction;

import eu.janschupke.buddy.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.buddy.content.config.enumeration.tags.SituationTags;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Situation;

/**
 * Initial situation for the coin interaction.
 *
 * @author jan.schupke@gmail.com
 */
public class InvestigateSituation extends Situation {
    public InvestigateSituation(final App app) {
        super(app, app.getLang().get("level.forest.interaction.coin.pickup.description"),
                SituationTags.FOREST_COIN_INVESTIGATE);
        decisions.add(new Decision(app.getLang().get("level.forest.interaction.coin.pickup.decision.pickup"),
                DecisionTags.FOREST_COIN_PICKUP));
        decisions.add(new Decision(app.getLang().get("level.forest.interaction.coin.pickup.decision.ignore"),
                DecisionTags.FOREST_COIN_IGNORE));
    }
}
