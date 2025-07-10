package io.schupke.tale.base.event;

import io.schupke.tale.base.App;

/**
 * Represents a general game event.
 * Handles miscellaneous game state changes and notifications.
 */
public abstract class GeneralEvent extends BaseEvent {
    public GeneralEvent(final App app) {
        this(app, "");
    }

    public GeneralEvent(final App app, final String eventMessage) {
        super(app, eventMessage);
    }

    @Override
    public final void trigger() {
        if (!canTrigger()) return;
        super.trigger();
        updateMessages();
        updateQuests();
        updateGameState();
        updateInteractions();
    }
}
