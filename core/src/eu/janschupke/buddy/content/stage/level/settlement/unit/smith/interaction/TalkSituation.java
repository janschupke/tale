package eu.janschupke.buddy.content.stage.level.settlement.unit.smith.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.config.enumeration.interaction.DecisionTags;
import eu.janschupke.buddy.framework.config.enumeration.interaction.SituationTags;

/**
 * Initial Smith interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class TalkSituation extends Situation {
    public TalkSituation(final App app) {
        super(app, app.getLang().get("level.settlement.interaction.smith.talk.description"),
                SituationTags.SETTLEMENT_SMITH_TALK);
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"), DecisionTags.GLOBAL_END));
    }
}