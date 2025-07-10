package io.schupke.tale.content.stage.level.forest.obstacle.caravan.interaction;

import io.schupke.tale.base.App;
import io.schupke.tale.base.entity.Triggerable;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.content.config.enumeration.tags.InteractionTags;

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
