package io.schupke.tale.content.stage.level.cave.event.interaction.corpsec;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.InteractionEvent;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Search body for items event.
 *
 * @author jan.schupke@gmail.com
 */
public class CorpsecSearchInteractionEvent extends InteractionEvent {
    public CorpsecSearchInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.CAVE_INTERACTION_CORPSEC_SEARCH, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
