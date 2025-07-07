package eu.janschupke.tale.content.stage.level.dungeon.obstacle.gate.interaction;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.interaction.Decision;
import eu.janschupke.tale.base.interaction.Situation;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Initial harpsichord interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class InvestigateSituation extends Situation {
    public InvestigateSituation(final App app) {
        super(app, app.getLang().get("level.dungeon.interaction.gate.investigate.description"),
                SituationTags.DUNGEON_GATE_INVESTIGATE);

        decisions.add(new Decision(app.getLang().get("level.dungeon.interaction.gate.investigate.decision.open"),
                DecisionTags.DUNGEON_GATE_OPEN, false));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
