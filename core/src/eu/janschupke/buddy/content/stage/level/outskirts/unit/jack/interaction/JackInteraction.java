package eu.janschupke.buddy.content.stage.level.outskirts.unit.jack.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.config.enumeration.tags.InteractionTags;

/**
 * Jack unit interaction class.
 *
 * @author jan.schupke@gmail.com
 */
public class JackInteraction extends Interaction {
    public JackInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.OUTSKIRTS_JACK);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.outskirts.interaction.jack.title");
        Situation talkSituation = new TalkSituation(app);
        situations.add(talkSituation);
        currentSituation = talkSituation;
        fallbackSituation = talkSituation;
    }

    @Override
    public void handle(Decision decision) {
        triggerable.endInteraction(app);
    }
}
