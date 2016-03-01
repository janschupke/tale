package eu.janschupke.buddy.content.stage.level.dungeon.unit.slave.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.config.enumeration.tags.InteractionTags;

/**
 * Interaction class for the slave unit.
 *
 * @author jan.schupke@gmail.com
 */
public class SlaveInteraction extends Interaction {
    public SlaveInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.DUNGEON_SLAVE);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.dungeon.interaction.slave.title");
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
