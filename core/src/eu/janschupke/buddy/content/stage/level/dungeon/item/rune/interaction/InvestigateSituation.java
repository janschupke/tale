package eu.janschupke.buddy.content.stage.level.dungeon.item.rune.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.config.enumeration.interaction.DecisionTags;
import eu.janschupke.buddy.framework.config.enumeration.interaction.SituationTags;

/**
 * Initial rune interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class InvestigateSituation extends Situation {
    public InvestigateSituation(final App app) {
        super(app, app.getLang().get("level.dungeon.interaction.rune.investigate.description"),
                SituationTags.DUNGEON_RUNE_INVESTIGATE);
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"), DecisionTags.GLOBAL_END));
    }
}