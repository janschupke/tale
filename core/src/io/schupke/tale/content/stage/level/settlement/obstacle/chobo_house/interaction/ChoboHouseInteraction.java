package io.schupke.tale.content.stage.level.settlement.obstacle.chobo_house.interaction;

import io.schupke.tale.base.App;
import io.schupke.tale.base.entity.Triggerable;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.content.config.enumeration.tags.InteractionTags;

/**
 * Interaction class for the Chobo's house.
 *
 * @author jan.schupke@gmail.com
 */
public class ChoboHouseInteraction extends Interaction {
    public ChoboHouseInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.SETTLEMENT_CHOBO_HOUSE);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.settlement.interaction.chobo-house.title");
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
