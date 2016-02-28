package eu.janschupke.buddy.content.stage.level.forest.unit.ukko.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Initial interaction situation.
 */
public class TalkSituation extends Situation {
    public TalkSituation(final App app) {
        super(app, app.getLang().get("level.forest.interaction.ukko.talk.description"));
        decisions.add(new DeliveryDecision());
        decisions.add(new EndDecision());
    }

    /**
     * Decision to give the coin to the unit.
     */
    class DeliveryDecision extends Decision {
        public DeliveryDecision() {
            super(app.getLang().get("level.forest.interaction.ukko.talk.decision.delivery"),
                    Config.Decisions.FOREST_UKKO_DELIVERY);
        }

        @Override
        protected void configureMetrics() {
            // Does not influence personality.
        }
    }

    /**
     * Decision to end the conversation.
     */
    class EndDecision extends Decision {
        public EndDecision() {
            super(app.getLang().get("level.forest.interaction.ukko.talk.decision.end"),
                    Config.Decisions.GLOBAL_END);
        }

        @Override
        protected void configureMetrics() {
            // Does not influence personality.
        }
    }
}
