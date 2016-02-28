package eu.janschupke.buddy.content.stage.level.outskirts.unit.crone.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.config.enumeration.DecisionTags;

/**
 * Initial crone interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class TalkSituation extends Situation {
    public TalkSituation(final App app) {
        super(app, app.getLang().get("level.outskirts.interaction.crone.talk.description"));
        decisions.add(new LeaveDecision());
    }

    /**
     * Decision to leave the interaction.
     */
    class LeaveDecision extends Decision {
        public LeaveDecision() {
            super(app.getLang().get("global.interaction.decision.end"),
                    DecisionTags.GLOBAL_END);
        }

        @Override
        protected void configureMetrics() {
            // Does not influence personality.
        }
    }
}
