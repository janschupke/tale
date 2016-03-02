package eu.janschupke.buddy.content.stage.level.dungeon.item.scroll.interaction;

import eu.janschupke.buddy.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.interaction.Situation;

/**
 * Interaction class for the scroll item.
 *
 * @author jan.schupke@gmail.com
 */
public class ScrollInteraction extends Interaction {
    public ScrollInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.DUNGEON_SCROLL);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.dungeon.interaction.scroll.title");
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
