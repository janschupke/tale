package eu.janschupke.tale.content.stage.level.outskirts.item.lumber.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.base.entity.Triggerable;
import eu.janschupke.tale.framework.base.interaction.Decision;
import eu.janschupke.tale.framework.base.interaction.Interaction;
import eu.janschupke.tale.framework.base.interaction.Situation;

/**
 * Lumber item interaction class.
 *
 * @author jan.schupke@gmail.com
 */
public class LumberInteraction extends Interaction {
    public LumberInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.OUTSKIRTS_LUMBER);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.outskirts.interaction.lumber.title");
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
