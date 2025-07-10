package io.schupke.tale.content.stage.level.outskirts.unit.crone.interaction.situation;

import io.schupke.tale.base.App;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

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
