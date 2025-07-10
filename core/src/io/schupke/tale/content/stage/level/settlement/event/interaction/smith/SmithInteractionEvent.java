package io.schupke.tale.content.stage.level.settlement.event.interaction.smith;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.InteractionEvent;
import io.schupke.tale.base.interaction.InteractionSwitch;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Interaction event for the Smith unit.
 *
 * @author jan.schupke@gmail.com
 */
public class SmithInteractionEvent extends InteractionEvent {
    public SmithInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.SETTLEMENT_INTERACTION_SMITH_TALK, ((BaseScreen) app.getScreen()).getTag());
        app.getResourceManager().getSoundHandler().playSpeech(
                app.getResourceManager().getSoundHandler().getSmithSound());
    }

    @Override
    protected void updateInteractions() {

    }
}
