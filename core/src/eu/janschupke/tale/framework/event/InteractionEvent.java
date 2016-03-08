package eu.janschupke.tale.framework.event;

import eu.janschupke.tale.framework.App;

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
        withDialog = true;
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
