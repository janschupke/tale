package eu.janschupke.buddy.content.stage.level.cave.unit.ville.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.config.enumeration.DecisionTags;

/**
 * Initial cave Ville interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class TalkSituation extends Situation {
    public TalkSituation(final App app) {
        super(app, app.getLang().get("level.cave.interaction.ville.talk.description"));
        decisions.add(new LeaveDecision());
    }

    /**
     * Decision to leave the interaction.
     */
    class LeaveDecision extends Decision {
        public LeaveDecision() {
            super(app.getLang().get("level.cave.interaction.ville.talk.decision.leave"),
                    DecisionTags.CAVE_VILLE_LEAVE);
        }

        @Override
        protected void configureMetrics() {
            // Does not influence personality.
        }
    }
}
