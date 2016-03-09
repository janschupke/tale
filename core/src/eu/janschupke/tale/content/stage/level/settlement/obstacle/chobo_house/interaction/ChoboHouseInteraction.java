package eu.janschupke.tale.content.stage.level.settlement.obstacle.chobo_house.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.interaction.Situation;

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