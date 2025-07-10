package io.schupke.tale.base.event;

import io.schupke.tale.base.App;

/**
 * Represents an interaction event.
 * Handles events related to player interactions with game objects.
 */
public abstract class InteractionEvent extends BaseEvent {
    public InteractionEvent(final App app) {
        this(app, "");
    }

    public InteractionEvent(final App app, final String eventMessage) {
        super(app, eventMessage);
        withDialog = true;
        repeatable = true;
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
