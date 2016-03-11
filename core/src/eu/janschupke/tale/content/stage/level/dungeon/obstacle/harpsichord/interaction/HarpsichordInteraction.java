package eu.janschupke.tale.content.stage.level.dungeon.obstacle.harpsichord.interaction;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.entity.Triggerable;
import eu.janschupke.tale.base.interaction.Decision;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.interaction.Situation;
import eu.janschupke.tale.base.screen.GameScreen;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.stage.level.dungeon.event.DungeonEventHandler;

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
