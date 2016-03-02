package eu.janschupke.tale.framework.base.event;

import eu.janschupke.tale.framework.App;

/**
 * Base event for exploration.
 *
 * @author jan.schupke@gmail.com
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
