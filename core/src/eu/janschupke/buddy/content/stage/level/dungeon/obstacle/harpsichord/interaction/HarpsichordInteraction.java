package eu.janschupke.buddy.content.stage.level.dungeon.obstacle.harpsichord.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.config.enumeration.tags.InteractionTags;

/**
 * Interaction class for the harpsichord obstacle.
 *
 * @author jan.schupke@gmail.com
 */
public class HarpsichordInteraction extends Interaction {
    public HarpsichordInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.DUNGEON_HARPSICHORD);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.dungeon.interaction.harpsichord.title");
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
