package eu.janschupke.buddy.content.stage.level.forest.obstacle.caravan.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.config.enumeration.tags.InteractionTags;

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
