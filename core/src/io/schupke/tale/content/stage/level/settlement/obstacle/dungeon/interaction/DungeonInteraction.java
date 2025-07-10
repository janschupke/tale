package io.schupke.tale.content.stage.level.settlement.obstacle.dungeon.interaction;

import io.schupke.tale.base.App;
import io.schupke.tale.base.entity.Triggerable;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.interaction.Situation;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.InteractionTags;
import io.schupke.tale.content.stage.level.settlement.event.SettlementEventHandler;

/**
 * Interaction class for the dungeon structure.
 *
 * @author jan.schupke@gmail.com
 */
public class DungeonInteraction extends Interaction {
    public DungeonInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.SETTLEMENT_DUNGEON);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.settlement.interaction.dungeon.title");
        Situation investigateSituation = new InvestigateSituation(app);
        situations.add(investigateSituation);
        currentSituation = investigateSituation;
        fallbackSituation = investigateSituation;
    }

    @Override
    public void handle(Decision decision) {
        if (decision.getTag().equals(DecisionTags.SETTLEMENT_DUNGEON_ENTER)) {
            ((SettlementEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getDungeonTransitionEvent().trigger();
        } else {
            triggerable.endInteraction(app);
        }
    }
}
