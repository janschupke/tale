package eu.janschupke.buddy.content.stage.level.dungeon.unit.rudolf.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.config.enumeration.interaction.DecisionTags;
import eu.janschupke.buddy.framework.config.enumeration.interaction.SituationTags;

/**
 * Initial dungeon Rudolf interaction situation.
 *
 * @author jan.schupke@gmail.com
 */
public class TalkSituation extends Situation {
    public TalkSituation(final App app) {
        super(app, app.getLang().get("level.dungeon.interaction.rudolf.talk.description"),
                SituationTags.DUNGEON_RUDOLF_TALK);
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"), DecisionTags.GLOBAL_END));
    }
}
