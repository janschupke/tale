package eu.janschupke.tale.content.stage.level.settlement.obstacle.road_sign.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.base.entity.Triggerable;
import eu.janschupke.tale.framework.base.interaction.Decision;
import eu.janschupke.tale.framework.base.interaction.Interaction;
import eu.janschupke.tale.framework.base.interaction.Situation;

/**
 * Interaction class for the road sign.
 *
 * @author jan.schupke@gmail.com
 */
public class RoadSignInteraction extends Interaction {
    public RoadSignInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.SETTLEMENT_ROAD_SIGN);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.settlement.interaction.road-sign.title");
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
