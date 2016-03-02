package eu.janschupke.buddy.content.stage.level.house.obstacle.book_shelf.interaction;

import eu.janschupke.buddy.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.buddy.content.config.enumeration.tags.SituationTags;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Situation;

/**
 * Initial house bookshelf interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class InvestigateSituation extends Situation {
    public InvestigateSituation(final App app) {
        super(app, app.getLang().get("level.house.interaction.book-shelf.investigate.description"),
                SituationTags.HOUSE_BOOK_SHELF_INVESTIGATE);
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"), DecisionTags.GLOBAL_END));
    }
}
