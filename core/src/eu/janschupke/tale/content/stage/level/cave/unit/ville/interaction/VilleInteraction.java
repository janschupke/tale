package eu.janschupke.tale.content.stage.level.cave.unit.ville.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.interaction.Situation;

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