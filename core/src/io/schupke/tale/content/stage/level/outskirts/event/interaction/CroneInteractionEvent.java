package io.schupke.tale.content.stage.level.outskirts.event.interaction;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.InteractionEvent;
import io.schupke.tale.base.interaction.InteractionSwitch;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Event for Crone interactions in the outskirts.
 * Handles conversations with the Crone character.
 */
public class CroneInteractionEvent extends InteractionEvent {
    public CroneInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_INTERACTION_CRONE_TALK, ((BaseScreen) app.getScreen()).getTag());
        app.getResourceManager().getSoundHandler().playSpeech(
                app.getResourceManager().getSoundHandler().getCroneSound());
    }

    @Override
    protected void updateInteractions() {

    }
}
