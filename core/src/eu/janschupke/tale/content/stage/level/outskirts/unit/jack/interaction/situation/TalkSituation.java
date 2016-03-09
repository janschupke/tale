package eu.janschupke.tale.content.stage.level.outskirts.unit.jack.interaction.situation;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Situation;

/**
 * Initial Jack interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class TalkSituation extends Situation {
    public TalkSituation(final App app) {
        super(app, app.getLang().get("level.outskirts.interaction.jack.talk.description"),
                SituationTags.OUTSKIRTS_JACK_TALK);

        decisions.add(new Decision(app.getLang().get("level.outskirts.interaction.jack.talk.decision.crone"),
                DecisionTags.OUTSKIRTS_JACK_CRONE));
        decisions.add(new Decision(app.getLang().get("level.outskirts.interaction.jack.talk.decision.forest"),
                DecisionTags.OUTSKIRTS_JACK_FOREST));
        decisions.add(new Decision(app.getLang().get("level.outskirts.interaction.jack.talk.decision.dispute"),
                DecisionTags.OUTSKIRTS_JACK_DISPUTE, false));
        decisions.add(new Decision(app.getLang().get("level.outskirts.interaction.jack.talk.decision.lumber-give"),
                DecisionTags.OUTSKIRTS_JACK_LUMBER_GIVE, false));
        decisions.add(new Decision(app.getLang().get("level.outskirts.interaction.jack.talk.decision.book-give"),
                DecisionTags.OUTSKIRTS_JACK_BOOK_GIVE, false));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}