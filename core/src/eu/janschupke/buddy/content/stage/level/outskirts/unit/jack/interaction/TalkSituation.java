package eu.janschupke.buddy.content.stage.level.outskirts.unit.jack.interaction;

import eu.janschupke.buddy.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.buddy.content.config.enumeration.tags.SituationTags;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Situation;

/**
 * Initial Jack interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class TalkSituation extends Situation {
    public TalkSituation(final App app) {
        super(app, app.getLang().get("level.outskirts.interaction.jack.talk.description"),
                SituationTags.OUTSKIRTS_JACK_TALK);
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"), DecisionTags.GLOBAL_END));
    }
}
