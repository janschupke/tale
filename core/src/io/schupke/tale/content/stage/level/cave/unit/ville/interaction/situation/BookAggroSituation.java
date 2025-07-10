package io.schupke.tale.content.stage.level.cave.unit.ville.interaction.situation;

import io.schupke.tale.base.App;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

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
