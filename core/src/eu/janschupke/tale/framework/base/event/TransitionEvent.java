package eu.janschupke.tale.framework.base.event;

import eu.janschupke.tale.framework.App;

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
