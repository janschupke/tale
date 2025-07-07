package eu.janschupke.tale.content.stage.level.cave.unit.corpsec.interaction;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.entity.Triggerable;
import eu.janschupke.tale.base.interaction.Decision;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.interaction.Situation;
import eu.janschupke.tale.base.screen.GameScreen;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.stage.level.cave.event.CaveEventHandler;
import eu.janschupke.tale.content.stage.level.cave.unit.corpsec.interaction.situation.InvestigateSituation;
import eu.janschupke.tale.content.stage.level.cave.unit.corpsec.interaction.situation.SearchSituation;

/**
 * Interaction class for the Corpsec unit.
 *
 * @author jan.schupke@gmail.com
 */
public class CorpsecInteraction extends Interaction {
    private Situation searchSituation;

    public CorpsecInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.CAVE_CORPSEC);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.cave.interaction.corpsec.title");
        Situation investigateSituation = new InvestigateSituation(app);
        searchSituation = new SearchSituation(app);
        situations.add(investigateSituation);
        situations.add(searchSituation);
        currentSituation = investigateSituation;
        fallbackSituation = investigateSituation;
    }

    @Override
    public void handle(Decision decision) {
        if (decision.getTag().equals(DecisionTags.CAVE_CORPSEC_INVESTIGATE_SEARCH)) {
            ((CaveEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getCorpsecSearchInteractionEvent().trigger();
            transition(searchSituation, app);
        } else if (decision.getTag().equals(DecisionTags.CAVE_CORPSEC_SEARCH_LOOT)) {
            ((CaveEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getCorpsecLootInteractionEvent().trigger();
            triggerable.endInteraction(app);
        } else {
            triggerable.endInteraction(app);
        }
    }
}
