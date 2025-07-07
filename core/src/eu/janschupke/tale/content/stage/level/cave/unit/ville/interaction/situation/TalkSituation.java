package eu.janschupke.tale.content.stage.level.cave.unit.ville.interaction.situation;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.interaction.Decision;
import eu.janschupke.tale.base.interaction.Situation;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Initial cave Ville interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class TalkSituation extends Situation {
    public TalkSituation(final App app) {
        super(app, app.getLang().get("level.cave.interaction.ville.talk.description"), SituationTags.CAVE_VILLE_TALK);

        decisions.add(new Decision(app.getLang().get("level.cave.interaction.ville.talk.decision.inquiry"),
                DecisionTags.CAVE_VILLE_TALK_INQUIRY, false));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
