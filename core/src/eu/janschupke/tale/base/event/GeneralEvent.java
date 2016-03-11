package eu.janschupke.tale.base.event;

import eu.janschupke.tale.base.App;

/**
 * Base event for any generic actions that might not fit into other event types.
 *
 * @author jan.schupke@gmail.com
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
