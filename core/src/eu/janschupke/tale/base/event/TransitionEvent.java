package eu.janschupke.tale.base.event;

import eu.janschupke.tale.base.App;

/**
 * Base event for screen transitioning.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class TransitionEvent extends BaseEvent {
    public TransitionEvent(final App app) {
        this(app, "");
    }

    public TransitionEvent(final App app, final String eventMessage) {
        super(app, eventMessage);
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
