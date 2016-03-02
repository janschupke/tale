package eu.janschupke.tale.content.stage.level.dungeon.obstacle.room_four_door.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.interaction.Situation;

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
