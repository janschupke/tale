package io.schupke.tale.base.event;

import io.schupke.tale.base.App;

/**
 * Represents an exploration event.
 * Handles events related to player exploration and discovery.
 */
public abstract class ExplorationEvent extends BaseEvent {
    public ExplorationEvent(final App app) {
        this(app, "");
    }

    public ExplorationEvent(final App app, final String eventMessage) {
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
