package eu.janschupke.buddy.content.stage.level.forest.item.coin.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.config.enumeration.DecisionTags;

/**
 * Initial situation for the coin interaction.
 *
 * @author jan.schupke@gmail.com
 */
public class PickupSituation extends Situation {
    public PickupSituation(final App app) {
        super(app, app.getLang().get("level.forest.interaction.coin.pickup.description"));
        decisions.add(new PickupDecision());
        decisions.add(new IgnoreDecision());
    }

    /**
     * Decision to pick the coin from the ground.
     */
    class PickupDecision extends Decision {
        public PickupDecision() {
            super(app.getLang().get("level.forest.interaction.coin.pickup.decision.pickup"),
                    DecisionTags.FOREST_COIN_PICKUP);
        }

        @Override
        protected void configureMetrics() {
            // Does not influence personality.
        }
    }

    /**
     * Decision to ignore the coin and not pick it up.
     */
    class IgnoreDecision extends Decision {
        public IgnoreDecision() {
            super(app.getLang().get("level.forest.interaction.coin.pickup.decision.ignore"),
                    DecisionTags.FOREST_COIN_IGNORE);
        }

        @Override
        protected void configureMetrics() {
            // Does not influence personality.
        }
    }
}
