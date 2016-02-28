package eu.janschupke.buddy.content.stage.level.cave.obstacle.spring.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.config.enumeration.DecisionTags;

/**
 * Initial cave spring interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class InvestigateSituation extends Situation {
    public InvestigateSituation(final App app) {
        super(app, app.getLang().get("level.cave.interaction.spring.investigate.description"));
        decisions.add(new LeaveDecision());
    }

    /**
     * Decision to leave the interaction.
     */
    class LeaveDecision extends Decision {
        public LeaveDecision() {
            super(app.getLang().get("level.cave.interaction.spring.investigate.decision.leave"),
                    DecisionTags.CAVE_SPRING_LEAVE);
        }

        @Override
        protected void configureMetrics() {
            // Does not influence personality.
        }
    }
}
