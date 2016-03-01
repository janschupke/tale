package eu.janschupke.buddy.content.stage.level.cave.unit.ville.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.config.enumeration.tags.DecisionTags;
import eu.janschupke.buddy.framework.config.enumeration.tags.SituationTags;

/**
 * Initial cave Ville interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class TalkSituation extends Situation {
    public TalkSituation(final App app) {
        super(app, app.getLang().get("level.cave.interaction.ville.talk.description"), SituationTags.CAVE_VILLE_TALK);
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"), DecisionTags.GLOBAL_END));
    }
}
