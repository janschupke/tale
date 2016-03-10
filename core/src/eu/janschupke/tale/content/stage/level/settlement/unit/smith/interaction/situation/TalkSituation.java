package eu.janschupke.tale.content.stage.level.settlement.unit.smith.interaction.situation;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Situation;

/**
 * Initial Smith interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class TalkSituation extends Situation {
    public TalkSituation(final App app) {
        super(app, app.getLang().get("level.settlement.interaction.smith.talk.description"),
                SituationTags.SETTLEMENT_SMITH_TALK);

        decisions.add(new Decision(app.getLang().get("level.settlement.interaction.smith.talk.decision.assistance"),
                DecisionTags.SETTLEMENT_SMITH_ASSISTANCE));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
