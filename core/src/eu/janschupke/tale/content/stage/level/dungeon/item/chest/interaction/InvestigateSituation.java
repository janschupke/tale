package eu.janschupke.tale.content.stage.level.dungeon.item.chest.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.base.interaction.Decision;
import eu.janschupke.tale.framework.base.interaction.Situation;

/**
 * Initial chest interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class InvestigateSituation extends Situation {
    public InvestigateSituation(final App app) {
        super(app, app.getLang().get("level.dungeon.interaction.chest.investigate.description"),
                SituationTags.DUNGEON_CHEST_INVESTIGATE);
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"), DecisionTags.GLOBAL_END));
    }
}
