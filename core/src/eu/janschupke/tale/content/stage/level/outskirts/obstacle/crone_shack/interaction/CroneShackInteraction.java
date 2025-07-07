package eu.janschupke.tale.content.stage.level.outskirts.obstacle.crone_shack.interaction;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.entity.Triggerable;
import eu.janschupke.tale.base.interaction.Decision;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.interaction.Situation;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;

/**
 * Interaction class for the Crone shack.
 *
 * @author jan.schupke@gmail.com
 */
public class CroneShackInteraction extends Interaction {
    public CroneShackInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.OUTSKIRTS_CRONE_SHACK);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.outskirts.interaction.crone-shack.title");
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
