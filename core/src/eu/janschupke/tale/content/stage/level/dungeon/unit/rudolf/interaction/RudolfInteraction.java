package eu.janschupke.tale.content.stage.level.dungeon.unit.rudolf.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.interaction.Situation;

/**
 * Interaction class for the Rudolf unit.
 *
 * @author jan.schupke@gmail.com
 */
public class RudolfInteraction extends Interaction {
    public RudolfInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.DUNGEON_RUDOLF);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.dungeon.interaction.rudolf.title");
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
