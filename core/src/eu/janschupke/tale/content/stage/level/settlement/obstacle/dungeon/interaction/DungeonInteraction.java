package eu.janschupke.tale.content.stage.level.settlement.obstacle.dungeon.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.interaction.Situation;

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
        triggerable.endInteraction(app);
    }
}
