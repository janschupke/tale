package io.schupke.tale.content.stage.level.outskirts.event.interaction.jack;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.InteractionEvent;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Explicit dispute discussion request.
 *
 * @author jan.schupke@gmail.com
 */
public class JackDisputeRequestInteractionEvent extends InteractionEvent {
    public JackDisputeRequestInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_INTERACTION_JACK_DISPUTE_REQUEST, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
