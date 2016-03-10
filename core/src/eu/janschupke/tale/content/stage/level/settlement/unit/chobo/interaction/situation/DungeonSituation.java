package eu.janschupke.tale.content.stage.level.settlement.unit.chobo.interaction.situation;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Situation;

/**
 * Dungeon rambling situation.
 *
 * @author jan.schupke@gmail.com
 */
public class DungeonSituation extends Situation {
    public DungeonSituation(final App app) {
        super(app, app.getLang().get("level.settlement.interaction.chobo.dungeon.description"),
                SituationTags.SETTLEMENT_CHOBO_DUNGEON);

        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}