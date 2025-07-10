package io.schupke.tale.content.stage.level.settlement.obstacle.fountain.interaction;

import io.schupke.tale.base.App;
import io.schupke.tale.base.entity.Triggerable;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.content.config.enumeration.tags.InteractionTags;

/**
 * Interaction class for the fountain.
 *
 * @author jan.schupke@gmail.com
 */
public class FountainInteraction extends Interaction {
    public FountainInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.SETTLEMENT_FOUNTAIN);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.settlement.interaction.fountain.title");
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
