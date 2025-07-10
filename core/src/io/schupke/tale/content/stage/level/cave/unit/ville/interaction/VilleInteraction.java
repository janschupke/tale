package io.schupke.tale.content.stage.level.cave.unit.ville.interaction;

import io.schupke.tale.base.App;
import io.schupke.tale.base.entity.Triggerable;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.InteractionTags;
import io.schupke.tale.content.stage.level.cave.event.CaveEventHandler;
import io.schupke.tale.content.stage.level.cave.unit.ville.interaction.situation.BookAggroSituation;
import io.schupke.tale.content.stage.level.cave.unit.ville.interaction.situation.BookInquirySituation;
import io.schupke.tale.content.stage.level.cave.unit.ville.interaction.situation.BookLeaveSituation;
import io.schupke.tale.content.stage.level.cave.unit.ville.interaction.situation.TalkSituation;

/**
 * Interaction class for the Ville unit.
 *
 * @author jan.schupke@gmail.com
 */
public class VilleInteraction extends Interaction {
    private Situation bookInquirySituation;
    private Situation bookAggroSituation;
    private Situation bookLeaveSituation;

    public VilleInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.CAVE_VILLE);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.cave.interaction.ville.title");
        Situation talkSituation = new TalkSituation(app);
        bookInquirySituation = new BookInquirySituation(app);
        bookAggroSituation = new BookAggroSituation(app);
        bookLeaveSituation = new BookLeaveSituation(app);
        situations.add(talkSituation);
        situations.add(bookInquirySituation);
        situations.add(bookAggroSituation);
        situations.add(bookLeaveSituation);
        currentSituation = talkSituation;
        fallbackSituation = talkSituation;
    }

    @Override
    public void handle(Decision decision) {
        if (decision.getTag().equals(DecisionTags.CAVE_VILLE_TALK_INQUIRY)) {
            ((CaveEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getVilleInquiryInteractionEvent().trigger();
            transition(bookInquirySituation, app);
        } else if (decision.getTag().equals(DecisionTags.CAVE_VILLE_INQUIRY_AGGRO)) {
            ((CaveEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getVilleAggroInteractionEvent().trigger();
            transition(bookAggroSituation, app);
        } else if (decision.getTag().equals(DecisionTags.CAVE_VILLE_INQUIRY_LEAVE)) {
            ((CaveEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getVilleLeaveInteractionEvent().trigger();
            transition(bookLeaveSituation, app);
        } else {
            triggerable.endInteraction(app);
        }
    }
}
