package eu.janschupke.tale.content.stage.level.outskirts.unit.jack.interaction.situation;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.interaction.Decision;
import eu.janschupke.tale.base.interaction.Situation;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Lumber quest was accepted.
 *
 * @author jan.schupke@gmail.com
 */
public class LumberAcceptedSituation extends Situation {
    public LumberAcceptedSituation(final App app) {
        super(app, app.getLang().get("level.outskirts.interaction.jack.lumber-accept.description"),
                SituationTags.OUTSKIRTS_JACK_LUMBER_ACCEPT);

        decisions.add(new Decision(app.getLang().get("level.outskirts.interaction.jack.lumber-accept.decision.lumber-give"),
                DecisionTags.OUTSKIRTS_JACK_LUMBER_GIVE, false));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
