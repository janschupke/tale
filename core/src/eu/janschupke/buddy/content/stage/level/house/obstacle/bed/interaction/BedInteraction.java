package eu.janschupke.buddy.content.stage.level.house.obstacle.bed.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.interaction.Situation;

/**
 * Interaction class for the bed obstacle.
 *
 * @author jan.schupke@gmail.com
 */
public class BedInteraction extends Interaction {
    public BedInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.house.interaction.bed.title");
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
