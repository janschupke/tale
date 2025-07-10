package io.schupke.tale.content.stage.level.cave.unit.ville.interaction.situation;

import io.schupke.tale.base.App;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Book inquiry.
 *
 * @author jan.schupke@gmail.com
 */
public class BookInquirySituation extends Situation {
    public BookInquirySituation(final App app) {
        super(app, app.getLang().get("level.cave.interaction.ville.book-inquiry.description"), SituationTags.CAVE_VILLE_BOOK_INQUIRY);

        decisions.add(new Decision(app.getLang().get("level.cave.interaction.ville.book-inquiry.decision.aggro"),
                DecisionTags.CAVE_VILLE_INQUIRY_AGGRO));
        decisions.add(new Decision(app.getLang().get("level.cave.interaction.ville.book-inquiry.decision.leave"),
                DecisionTags.CAVE_VILLE_INQUIRY_LEAVE));
        decisions.add(new Decision(app.getLang().get("global.interaction.decision.end"),
                DecisionTags.GLOBAL_END));
    }
}
