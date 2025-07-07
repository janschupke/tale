package eu.janschupke.tale.content.stage.level.dungeon.obstacle.gate.interaction;

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
