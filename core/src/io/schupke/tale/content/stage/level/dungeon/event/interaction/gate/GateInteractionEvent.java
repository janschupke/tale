package io.schupke.tale.content.stage.level.dungeon.event.interaction.gate;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.InteractionEvent;
import io.schupke.tale.base.interaction.InteractionSwitch;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Event for gate interactions in the dungeon.
 * Handles gate opening and closing mechanics.
 */
public class GateInteractionEvent extends InteractionEvent {
    public GateInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.DUNGEON_INTERACTION_GATE_INVESTIGATE, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
