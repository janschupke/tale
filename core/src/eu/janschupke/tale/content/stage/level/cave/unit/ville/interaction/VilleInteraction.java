package eu.janschupke.tale.content.stage.level.cave.unit.ville.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.stage.level.cave.event.CaveEventHandler;
import eu.janschupke.tale.content.stage.level.cave.unit.ville.interaction.situation.BookAggroSituation;
import eu.janschupke.tale.content.stage.level.cave.unit.ville.interaction.situation.BookInquirySituation;
import eu.janschupke.tale.content.stage.level.cave.unit.ville.interaction.situation.BookLeaveSituation;
import eu.janschupke.tale.content.stage.level.cave.unit.ville.interaction.situation.TalkSituation;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.interaction.Situation;
import eu.janschupke.tale.framework.screen.GameScreen;

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
