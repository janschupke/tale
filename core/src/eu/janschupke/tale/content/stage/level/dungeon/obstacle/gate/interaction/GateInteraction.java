package eu.janschupke.tale.content.stage.level.dungeon.obstacle.gate.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.stage.level.dungeon.event.DungeonEventHandler;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.interaction.Situation;
import eu.janschupke.tale.framework.screen.GameScreen;

/**
 * Interaction class for the first room gate.
 *
 * @author jan.schupke@gmail.com
 */
public class GateInteraction extends Interaction {
    public GateInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.DUNGEON_ROOM_ONE_GATE);
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
