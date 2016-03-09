package eu.janschupke.tale.content.stage.level.settlement.event.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.interaction.InteractionSwitch;
import eu.janschupke.tale.framework.screen.BaseScreen;

/**
 * Interaction event for the road sign.
 *
 * @author jan.schupke@gmail.com
 */
public class RoadSignInteractionEvent extends InteractionEvent {
    public RoadSignInteractionEvent(final App app) {
        super(app);
    }

    @Override
    protected void updateMessages() {

    }

    @Override
    protected void updateQuests() {

    }

    @Override
    protected void updateGameState() {
        InteractionSwitch.getTriggerable().startInteraction(app);
        app.getGameLog().addEntry(GameEventTags.SETTLEMENT_INTERACTION_ROAD_SIGN_INVESTIGATE, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
