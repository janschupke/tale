package eu.janschupke.buddy.content.stage.level.dungeon.item.book_one.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.config.enumeration.DecisionTags;

/**
 * Initial book interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class InvestigateSituation extends Situation {
    public InvestigateSituation(final App app) {
        super(app, app.getLang().get("level.dungeon.interaction.book-one.investigate.description"));
        decisions.add(new LeaveDecision());
    }

    /**
     * Decision to leave the interaction.
     */
    class LeaveDecision extends Decision {
        public LeaveDecision() {
            super(app.getLang().get("level.dungeon.interaction.book-one.investigate.decision.leave"),
                    DecisionTags.DUNGEON_BOOK_ONE_LEAVE);
        }

        @Override
        protected void configureMetrics() {
            // Does not influence personality.
        }
    }
}
