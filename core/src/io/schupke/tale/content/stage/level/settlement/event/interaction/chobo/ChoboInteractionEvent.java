package io.schupke.tale.content.stage.level.settlement.event.interaction.chobo;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.InteractionEvent;
import io.schupke.tale.base.interaction.InteractionSwitch;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Interaction event for Chobo unit.
 *
 * @author jan.schupke@gmail.com
 */
public class ChoboInteractionEvent extends InteractionEvent {
    public ChoboInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.SETTLEMENT_INTERACTION_CHOBO_TALK, ((BaseScreen) app.getScreen()).getTag());
        app.getResourceManager().getSoundHandler().playSpeech(
                app.getResourceManager().getSoundHandler().getChoboSound());
    }

    @Override
    protected void updateInteractions() {

    }
}
