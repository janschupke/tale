package io.schupke.tale.content.stage.level.cave.unit.corpsec.interaction;

import io.schupke.tale.base.App;
import io.schupke.tale.base.entity.Triggerable;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.InteractionTags;
import io.schupke.tale.content.stage.level.cave.event.CaveEventHandler;
import io.schupke.tale.content.stage.level.cave.unit.corpsec.interaction.situation.InvestigateSituation;
import io.schupke.tale.content.stage.level.cave.unit.corpsec.interaction.situation.SearchSituation;

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
