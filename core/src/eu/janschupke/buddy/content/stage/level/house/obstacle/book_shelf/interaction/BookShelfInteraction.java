package eu.janschupke.buddy.content.stage.level.house.obstacle.book_shelf.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.config.enumeration.interaction.InteractionTags;

/**
 * Interaction class for the book shelf obstacle.
 *
 * @author jan.schupke@gmail.com
 */
public class BookShelfInteraction extends Interaction {
    public BookShelfInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.HOUSE_BOOK_SHELF);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.house.interaction.book-shelf.title");
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
