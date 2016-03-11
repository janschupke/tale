package eu.janschupke.tale.content.stage.level.outskirts.unit.crone.interaction.situation;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.interaction.Decision;
import eu.janschupke.tale.base.interaction.Situation;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Crone interaction situation after note reveal.
 *
 * @author jan.schupke@gmail.com
 */
public class NoteShowSituation extends Situation {
    public NoteShowSituation(final App app) {
        super(app, app.getLang().get("level.outskirts.interaction.crone.varpunen-show.description"),
                SituationTags.OUTSKIRTS_CRONE_VARPUNEN_SHOW);

        decisions.add(new Decision(app.getLang().get("level.outskirts.interaction.crone.varpunen-show.decision.give"),
                DecisionTags.OUTSKIRTS_CRONE_VARPUNEN_GIVE, false));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
