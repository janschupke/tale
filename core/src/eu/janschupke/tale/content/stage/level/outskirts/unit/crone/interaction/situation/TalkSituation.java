package eu.janschupke.tale.content.stage.level.outskirts.unit.crone.interaction.situation;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.interaction.Decision;
import eu.janschupke.tale.base.interaction.Situation;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Initial crone interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class TalkSituation extends Situation {
    public TalkSituation(final App app) {
        super(app, app.getLang().get("level.outskirts.interaction.crone.talk.description"),
                SituationTags.OUTSKIRTS_CRONE_TALK);

        decisions.add(new Decision(app.getLang().get("level.outskirts.interaction.crone.talk.decision.show"),
                DecisionTags.OUTSKIRTS_CRONE_VARPUNEN_SHOW, false));
        decisions.add(new Decision(app.getLang().get("level.outskirts.interaction.crone.talk.decision.give"),
                DecisionTags.OUTSKIRTS_CRONE_VARPUNEN_GIVE, false));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
