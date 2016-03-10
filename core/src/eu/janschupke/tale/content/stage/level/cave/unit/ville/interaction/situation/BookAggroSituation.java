package eu.janschupke.tale.content.stage.level.cave.unit.ville.interaction.situation;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Situation;

/**
 * Aggresive book taking.
 *
 * @author jan.schupke@gmail.com
 */
public class BookAggroSituation extends Situation {
    public BookAggroSituation(final App app) {
        super(app, app.getLang().get("level.cave.interaction.ville.book-aggro.description"), SituationTags.CAVE_VILLE_BOOK_AGGRO);

        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}