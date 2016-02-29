package eu.janschupke.buddy.content.stage.level.outskirts.obstacle.cave.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.config.enumeration.interaction.InteractionTags;

/**
 * Interaction class for the cave.
 *
 * @author jan.schupke@gmail.com
 */
public class CaveInteraction extends Interaction {
    public CaveInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.OUTSKIRTS_CAVE);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.outskirts.interaction.cave.title");
        Situation investigateSituation = new InvestigateSituation(app);
        situations.add(investigateSituation);
        currentSituation = investigateSituation;
        fallbackSituation = investigateSituation;
    }

    @Override
    public void handle(Decision decision) {
        triggerable.endInteraction(app);
    }
}
