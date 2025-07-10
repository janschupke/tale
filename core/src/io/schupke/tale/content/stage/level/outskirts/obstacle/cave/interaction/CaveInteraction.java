package io.schupke.tale.content.stage.level.outskirts.obstacle.cave.interaction;

import io.schupke.tale.base.App;
import io.schupke.tale.base.entity.Triggerable;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.InteractionTags;
import io.schupke.tale.content.stage.level.outskirts.event.OutskirtsEventHandler;

/**
 * Interaction class for the cave.
 *
 * @author jan.schupke@gmail.com
 */
public class CaveInteraction extends Interaction {
    public CaveInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.OUTSKIRTS_CAVE);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.outskirts.interaction.cave.title");
        Situation investigateSituation = new InvestigateSituation(app);
        situations.add(investigateSituation);
        currentSituation = investigateSituation;
        fallbackSituation = investigateSituation;
    }

    @Override
    public void handle(Decision decision) {
        if (decision.getTag().equals(DecisionTags.OUTSKIRTS_CAVE_ENTER)) {
            ((OutskirtsEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getCaveTransitionEvent().trigger();
        } else {
            triggerable.endInteraction(app);
        }
    }
}
