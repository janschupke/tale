package eu.janschupke.tale.content.stage.level.outskirts.unit.jack.interaction.situation;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Situation;

/**
 * Jack's crone rambling situation.
 *
 * @author jan.schupke@gmail.com
 */
public class CroneRamblingSituation extends Situation {
    public CroneRamblingSituation(final App app) {
        super(app, app.getLang().get("level.outskirts.interaction.jack.crone.description"),
                SituationTags.OUTSKIRTS_JACK_CRONE);

        decisions.add(new Decision(app.getLang().get("level.outskirts.interaction.jack.crone.decision.forest"),
                DecisionTags.OUTSKIRTS_JACK_TALK_FOREST));
        decisions.add(new Decision(app.getLang().get("level.outskirts.interaction.jack.crone.decision.lumber-give"),
                DecisionTags.OUTSKIRTS_JACK_LUMBER_GIVE, false));
        decisions.add(new Decision(app.getLang().get("level.outskirts.interaction.jack.crone.decision.book-give"),
                DecisionTags.OUTSKIRTS_JACK_TALK_BOOK_GIVE, false));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
