package eu.janschupke.buddy.content.stage.level.outskirts.obstacle.jack_house.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.interaction.Situation;

/**
 * Interaction class for the Jack's house.
 *
 * @author jan.schupke@gmail.com
 */
public class JackHouseInteraction extends Interaction {
    public JackHouseInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.outskirts.interaction.jack-house.title");
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
