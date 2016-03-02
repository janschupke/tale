package eu.janschupke.buddy.content.stage.level.outskirts.obstacle.road_sign.interaction;

import eu.janschupke.buddy.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.interaction.Situation;

/**
 * Interaction class for the road sign obstacle.
 *
 * @author jan.schupke@gmail.com
 */
public class RoadSignInteraction extends Interaction {
    public RoadSignInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.OUTSKIRTS_ROAD_SIGN);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.outskirts.interaction.road-sign.title");
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
