package eu.janschupke.tale.content.stage.level.outskirts.unit.crone.interaction;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.entity.Triggerable;
import eu.janschupke.tale.base.interaction.Decision;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.interaction.Situation;
import eu.janschupke.tale.base.screen.GameScreen;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.stage.level.outskirts.event.OutskirtsEventHandler;
import eu.janschupke.tale.content.stage.level.outskirts.unit.crone.interaction.situation.NoteGiveSituation;
import eu.janschupke.tale.content.stage.level.outskirts.unit.crone.interaction.situation.NoteShowSituation;
import eu.janschupke.tale.content.stage.level.outskirts.unit.crone.interaction.situation.TalkSituation;

/**
 * Crone unit interaction class.
 *
 * @author jan.schupke@gmail.com
 */
public class CroneInteraction extends Interaction {
    private Situation talkSituation;
    private Situation noteShowSituation;
    private Situation noteGiveSituation;

    public CroneInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.OUTSKIRTS_CRONE);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.outskirts.interaction.crone.title");
        talkSituation = new TalkSituation(app);
        noteShowSituation = new NoteShowSituation(app);
        noteGiveSituation = new NoteGiveSituation(app);
        situations.add(talkSituation);
        situations.add(noteShowSituation);
        situations.add(noteGiveSituation);
        currentSituation = talkSituation;
        fallbackSituation = talkSituation;
    }

    @Override
    public void handle(Decision decision) {
        if (decision.getTag().equals(DecisionTags.OUTSKIRTS_CRONE_VARPUNEN_SHOW)) {
            ((OutskirtsEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getVarpunenShowInteractionEvent().trigger();
            transition(noteShowSituation, app);
        } else if (decision.getTag().equals(DecisionTags.OUTSKIRTS_CRONE_VARPUNEN_GIVE)) {
            ((OutskirtsEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getVarpunenGiveInteractionEvent().trigger();
            transition(noteGiveSituation, app);
        } else {
            triggerable.endInteraction(app);
        }
    }
}
