package io.schupke.tale.content.stage.level.dungeon.obstacle.harpsichord.interaction;

import io.schupke.tale.base.App;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Initial harpsichord interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class InvestigateSituation extends Situation {
    public InvestigateSituation(final App app) {
        super(app, app.getLang().get("level.dungeon.interaction.harpsichord.investigate.description"),
                SituationTags.DUNGEON_HARPSICHORD_INVESTIGATE);

        decisions.add(new Decision(app.getLang().get("level.dungeon.interaction.harpsichord.investigate.decision.play"),
                DecisionTags.DUNGEON_HARPSICHORD_PLAY));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
