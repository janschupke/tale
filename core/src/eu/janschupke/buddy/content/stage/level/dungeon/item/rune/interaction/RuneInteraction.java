package eu.janschupke.buddy.content.stage.level.dungeon.item.rune.interaction;

import eu.janschupke.buddy.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.interaction.Situation;

/**
 * Interaction class for the rune item.
 *
 * @author jan.schupke@gmail.com
 */
public class RuneInteraction extends Interaction {
    public RuneInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.DUNGEON_RUNE);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.dungeon.interaction.rune.title");
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
