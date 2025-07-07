package eu.janschupke.tale.content.stage.level.settlement.obstacle.dungeon.interaction;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.entity.Triggerable;
import eu.janschupke.tale.base.interaction.Decision;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.interaction.Situation;
import eu.janschupke.tale.base.screen.GameScreen;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.stage.level.settlement.event.SettlementEventHandler;

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
