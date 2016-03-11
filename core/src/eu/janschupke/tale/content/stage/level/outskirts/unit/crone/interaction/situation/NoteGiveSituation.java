package eu.janschupke.tale.content.stage.level.outskirts.unit.crone.interaction.situation;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.interaction.Decision;
import eu.janschupke.tale.base.interaction.Situation;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Situation after note hand-in.
 *
 * @author jan.schupke@gmail.com
 */
public class NoteGiveSituation extends Situation {
    public NoteGiveSituation(final App app) {
        super(app, app.getLang().get("level.outskirts.interaction.crone.varpunen-give.description"),
                SituationTags.OUTSKIRTS_CRONE_VARPUNEN_GIVE);

        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
