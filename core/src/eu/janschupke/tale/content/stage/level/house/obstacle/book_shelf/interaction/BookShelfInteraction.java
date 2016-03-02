package eu.janschupke.tale.content.stage.level.house.obstacle.book_shelf.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.interaction.Situation;

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
