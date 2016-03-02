package eu.janschupke.tale.content.stage.level.outskirts.unit.crone.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.base.interaction.Decision;
import eu.janschupke.tale.framework.base.interaction.Situation;

/**
 * Initial crone interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class TalkSituation extends Situation {
    public TalkSituation(final App app) {
        super(app, app.getLang().get("level.outskirts.interaction.crone.talk.description"),
                SituationTags.OUTSKIRTS_CRONE_TALK);
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"), DecisionTags.GLOBAL_END));
    }
}
