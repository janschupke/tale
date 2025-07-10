package io.schupke.tale.content.stage.level.dungeon.obstacle.harpsichord.interaction;

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
 * Interaction class for the harpsichord obstacle.
 *
 * @author jan.schupke@gmail.com
 */
public class HarpsichordInteraction extends Interaction {
    public HarpsichordInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.DUNGEON_HARPSICHORD);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.dungeon.interaction.harpsichord.title");
        Situation investigateSituation = new InvestigateSituation(app);
        situations.add(investigateSituation);
        currentSituation = investigateSituation;
        fallbackSituation = investigateSituation;
    }

    @Override
    public void handle(Decision decision) {
        if (decision.getTag().equals(DecisionTags.DUNGEON_HARPSICHORD_PLAY)) {
            ((DungeonEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler())
                    .getHarpsichordPlayInteractionEvent().trigger();
        } else {
            triggerable.endInteraction(app);
        }
    }
}
