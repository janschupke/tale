package eu.janschupke.tale.content.stage.level.forest.obstacle.caravan.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.base.entity.Triggerable;
import eu.janschupke.tale.framework.base.interaction.Decision;
import eu.janschupke.tale.framework.base.interaction.Interaction;
import eu.janschupke.tale.framework.base.interaction.Situation;

/**
 * Interaction class for the caravan wreck.
 *
 * @author jan.schupke@gmail.com
 */
public class CaravanInteraction extends Interaction {
    public CaravanInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.FOREST_CARAVAN);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.forest.interaction.caravan.title");
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
