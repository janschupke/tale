package eu.janschupke.tale.content.stage.level.settlement.obstacle.blacksmith.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.interaction.Situation;

/**
 * Interaction class for the blacksmith building.
 *
 * @author jan.schupke@gmail.com
 */
public class BlacksmithInteraction extends Interaction {
    public BlacksmithInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.SETTLEMENT_BLACKSMITH);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.settlement.interaction.blacksmith.title");
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
