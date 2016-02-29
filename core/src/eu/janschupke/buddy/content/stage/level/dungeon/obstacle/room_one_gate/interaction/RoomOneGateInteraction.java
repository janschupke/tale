package eu.janschupke.buddy.content.stage.level.dungeon.obstacle.room_one_gate.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.config.enumeration.interaction.InteractionTags;

/**
 * Interaction class for the first room gate.
 *
 * @author jan.schupke@gmail.com
 */
public class RoomOneGateInteraction extends Interaction {
    public RoomOneGateInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.DUNGEON_ROOM_ONE_GATE);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.dungeon.interaction.gate-one.title");
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
