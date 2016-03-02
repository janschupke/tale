package eu.janschupke.tale.content.stage.level.cave.unit.corpsec.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.interaction.Situation;

/**
 * Interaction class for the Corpsec unit.
 *
 * @author jan.schupke@gmail.com
 */
public class CorpsecInteraction extends Interaction {
    public CorpsecInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.CAVE_CORPSEC);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.cave.interaction.corpsec.title");
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
