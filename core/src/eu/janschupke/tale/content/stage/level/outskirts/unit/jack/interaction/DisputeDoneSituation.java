package eu.janschupke.tale.content.stage.level.outskirts.unit.jack.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Situation;

/**
 * Created by uzivatel on 09/03/2016.
 */
public class DisputeDoneSituation extends Situation {
    public DisputeDoneSituation(final App app) {
        super(app, app.getLang().get("level.outskirts.interaction.jack.dispute-done.description"),
                SituationTags.OUTSKIRTS_JACK_DISPUTE_DONE);

        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
