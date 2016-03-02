package eu.janschupke.buddy.content.stage.level.settlement.unit.chobo.interaction;

import eu.janschupke.buddy.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.buddy.content.config.enumeration.tags.SituationTags;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Situation;

/**
 * Initial Chobo interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class TalkSituation extends Situation {
    public TalkSituation(final App app) {
        super(app, app.getLang().get("level.settlement.interaction.chobo.talk.description"),
                SituationTags.SETTLEMENT_CHOBO_TALK);
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"), DecisionTags.GLOBAL_END));
    }
}
