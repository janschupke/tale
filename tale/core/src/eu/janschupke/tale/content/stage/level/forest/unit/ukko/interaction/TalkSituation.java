package eu.janschupke.tale.content.stage.level.forest.unit.ukko.interaction;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.interaction.Decision;
import eu.janschupke.tale.base.interaction.Situation;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;

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
                DecisionTags.FOREST_UKKO_DELIVERY, false));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
