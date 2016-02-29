package eu.janschupke.buddy.content.stage.level.cave.unit.ville.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.config.enumeration.interaction.InteractionTags;

/**
 * Interaction class for the Ville unit.
 *
 * @author jan.schupke@gmail.com
 */
public class VilleInteraction extends Interaction {
    public VilleInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.CAVE_VILLE);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.cave.interaction.ville.title");
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
