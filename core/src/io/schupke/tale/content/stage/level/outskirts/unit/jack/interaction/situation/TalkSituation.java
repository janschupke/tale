package io.schupke.tale.content.stage.level.outskirts.unit.jack.interaction.situation;

import io.schupke.tale.base.App;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Initial Jack interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class TalkSituation extends Situation {
    public TalkSituation(final App app) {
        super(app, app.getLang().get("level.outskirts.interaction.jack.talk.description"),
                SituationTags.OUTSKIRTS_JACK_TALK);

        decisions.add(new Decision(app.getLang().get("level.outskirts.interaction.jack.talk.decision.forest"),
                DecisionTags.OUTSKIRTS_JACK_TALK_FOREST));
        decisions.add(new Decision(app.getLang().get("level.outskirts.interaction.jack.talk.decision.dispute"),
                DecisionTags.OUTSKIRTS_JACK_TALK_DISPUTE, false));
        decisions.add(new Decision(app.getLang().get("level.outskirts.interaction.jack.talk.decision.lumber-give"),
                DecisionTags.OUTSKIRTS_JACK_LUMBER_GIVE, false));
        decisions.add(new Decision(app.getLang().get("level.outskirts.interaction.jack.talk.decision.book-give"),
                DecisionTags.OUTSKIRTS_JACK_TALK_BOOK_GIVE, false));
        decisions.add(new Decision(app.getLang().get("level.outskirts.interaction.jack.talk.decision.fail"),
                DecisionTags.OUTSKIRTS_JACK_TALK_FAIL, false));
        decisions.add(new Decision(app.getLang().get("level.outskirts.interaction.jack.talk.decision.crone"),
                DecisionTags.OUTSKIRTS_JACK_TALK_CRONE));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
