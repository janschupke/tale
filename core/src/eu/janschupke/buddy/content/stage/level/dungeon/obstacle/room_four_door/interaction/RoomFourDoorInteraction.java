package eu.janschupke.buddy.content.stage.level.dungeon.obstacle.room_four_door.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.config.enumeration.tags.InteractionTags;

/**
 * Interaction class for the fourth room door.
 *
 * @author jan.schupke@gmail.com
 */
public class RoomFourDoorInteraction extends Interaction {
    public RoomFourDoorInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.DUNGEON_ROOM_FOUR_DOOR);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.dungeon.interaction.door-four.title");
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
