package eu.janschupke.tale.content.stage.level.house.item.book.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.base.entity.Triggerable;
import eu.janschupke.tale.framework.base.interaction.Decision;
import eu.janschupke.tale.framework.base.interaction.Interaction;
import eu.janschupke.tale.framework.base.interaction.Situation;

/**
 * Interaction class for the book item.
 *
 * @author jan.schupke@gmail.com
 */
public class BookInteraction extends Interaction {
    public BookInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.HOUSE_BOOK);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.house.interaction.book.title");
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
