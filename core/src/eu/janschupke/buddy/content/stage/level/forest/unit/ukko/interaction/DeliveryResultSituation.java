package eu.janschupke.buddy.content.stage.level.forest.unit.ukko.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Situation that occurs right after the coin delivery.
 */
public class DeliveryResultSituation extends Situation {
    public DeliveryResultSituation(final App app) {
        super(app, app.getLang().get("level.forest.interaction.ukko.delivery-result.description"));
        decisions.add(new EndDecision());
    }

    /**
     * Decision to end the conversation.
     */
    private class EndDecision extends Decision {
        public EndDecision() {
            super(app.getLang().get("level.forest.interaction.ukko.delivery-result.decision.end"),
                    Config.Decisions.GLOBAL_END);
        }

        @Override
        protected void configureMetrics() {
            // Does not influence personality.
        }
    }
}
