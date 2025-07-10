package io.schupke.tale.content.stage.level.dungeon.obstacle.gate.interaction;

import io.schupke.tale.base.App;
import io.schupke.tale.base.entity.Triggerable;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.InteractionTags;
import io.schupke.tale.content.stage.level.dungeon.event.DungeonEventHandler;

/**
 * Interaction class for the first room gate.
 *
 * @author jan.schupke@gmail.com
 */
public class GateInteraction extends Interaction {
    public GateInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.DUNGEON_GATE);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.dungeon.interaction.gate.title");
        Situation investigateSituation = new InvestigateSituation(app);
        situations.add(investigateSituation);
        currentSituation = investigateSituation;
        fallbackSituation = investigateSituation;
    }

    @Override
    public void handle(Decision decision) {
        if (decision.getTag().equals(DecisionTags.DUNGEON_GATE_OPEN)) {
            ((DungeonEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler())
                    .getGateOpenInteractionEvent().trigger();
        }

        triggerable.endInteraction(app);
    }
}
