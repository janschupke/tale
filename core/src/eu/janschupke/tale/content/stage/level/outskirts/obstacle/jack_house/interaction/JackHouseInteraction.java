package eu.janschupke.tale.content.stage.level.outskirts.obstacle.jack_house.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.interaction.Situation;

/**
 * Interaction class for the Jack's house.
 *
 * @author jan.schupke@gmail.com
 */
public class JackHouseInteraction extends Interaction {
    public JackHouseInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.OUTSKIRTS_JACK_HOUSE);
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