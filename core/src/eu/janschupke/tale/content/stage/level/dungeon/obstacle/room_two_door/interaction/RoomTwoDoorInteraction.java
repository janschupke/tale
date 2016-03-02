package eu.janschupke.tale.content.stage.level.dungeon.obstacle.room_two_door.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.base.entity.Triggerable;
import eu.janschupke.tale.framework.base.interaction.Decision;
import eu.janschupke.tale.framework.base.interaction.Interaction;
import eu.janschupke.tale.framework.base.interaction.Situation;

/**
 * Interaction class for the second room door.
 *
 * @author jan.schupke@gmail.com
 */
public class RoomTwoDoorInteraction extends Interaction {
    public RoomTwoDoorInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.DUNGEON_ROOM_TWO_DOOR);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.dungeon.interaction.door-two.title");
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
