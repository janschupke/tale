package io.schupke.tale.content.stage.level.settlement.event.interaction;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.InteractionEvent;
import io.schupke.tale.base.interaction.InteractionSwitch;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Interaction event for the fountain object.
 *
 * @author jan.schupke@gmail.com
 */
public class FountainInteractionEvent extends InteractionEvent {
    public FountainInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.SETTLEMENT_INTERACTION_FOUNTAIN_INVESTIGATE, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
