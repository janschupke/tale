package io.schupke.tale.content.stage.level.outskirts.event.interaction.jack;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.InteractionEvent;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Lumber discussion request.
 *
 * @author jan.schupke@gmail.com
 */
public class JackLumberRequestInteractionEvent extends InteractionEvent {
    public JackLumberRequestInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_INTERACTION_JACK_LUMBER_REQUEST, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
