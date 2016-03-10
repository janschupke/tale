package eu.janschupke.tale.content.stage.level.outskirts.unit.jack.interaction.situation;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Situation;

/**
 * Book retrieval failed.
 *
 * @author jan.schupke@gmail.com
 */
public class FailSituation extends Situation {
    public FailSituation(final App app) {
        super(app, app.getLang().get("level.outskirts.interaction.jack.fail.description"),
                SituationTags.OUTSKIRTS_JACK_FAIL);

        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
