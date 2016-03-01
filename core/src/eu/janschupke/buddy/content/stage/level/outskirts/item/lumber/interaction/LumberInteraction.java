package eu.janschupke.buddy.content.stage.level.outskirts.item.lumber.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.config.enumeration.tags.InteractionTags;

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
