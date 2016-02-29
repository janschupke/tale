package eu.janschupke.buddy.framework.base.event;

import eu.janschupke.buddy.framework.App;

/**
 * Base event for all interactions.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class InteractionEvent extends BaseEvent {
    public InteractionEvent(final App app) {
        this(app, "");
    }

    public InteractionEvent(final App app, final String eventMessage) {
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
