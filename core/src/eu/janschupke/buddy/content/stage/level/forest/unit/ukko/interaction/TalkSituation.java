package eu.janschupke.buddy.content.stage.level.forest.unit.ukko.interaction;

import eu.janschupke.buddy.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.buddy.content.config.enumeration.tags.SituationTags;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Situation;

/**
 * Initial interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class TalkSituation extends Situation {
    public TalkSituation(final App app) {
        super(app, app.getLang().get("level.forest.interaction.ukko.talk.description"),
                SituationTags.FOREST_UKKO_TALK);

        decisions.add(new Decision(app.getLang().get("level.forest.interaction.ukko.talk.decision.purpose"),
                DecisionTags.FOREST_UKKO_DISCUSS));
        decisions.add(new Decision(app.getLang().get("level.forest.interaction.ukko.talk.decision.delivery"),
                DecisionTags.FOREST_UKKO_DELIVERY));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
