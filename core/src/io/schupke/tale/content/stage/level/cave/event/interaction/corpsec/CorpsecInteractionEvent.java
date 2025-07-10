package io.schupke.tale.content.stage.level.cave.event.interaction.corpsec;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.InteractionEvent;
import io.schupke.tale.base.interaction.InteractionSwitch;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Event for the Corpsec unit interaction.
 *
 * @author jan.schupke@gmail.com
 */
public class CorpsecInteractionEvent extends InteractionEvent {
    public CorpsecInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.CAVE_INTERACTION_CORPSEC_INVESTIGATE, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
